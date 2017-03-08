package chat.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import chat.controller.ChatbotController;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;
import twitter4j.Status;
import twitter4j.Paging;

public class CtecTwitter 
{
	private ChatbotController baseController;
	private Twitter twitterBot;
	private List<String> tweetedWords;
	private List<Status> allTheTweets;
	
	public CtecTwitter(ChatbotController baseController)
	{
		this.baseController = baseController;
		this.tweetedWords = new ArrayList<String>();
		this.allTheTweets = new ArrayList<Status>();
		this.twitterBot = TwitterFactory.getSingleton();
	}
	
	public void sendTweet(String textToTweet)
	{
		try
		{
			twitterBot.updateStatus(textToTweet + "@chatbotctec");
		}
		catch(TwitterException tweetError)
		{
			baseController.handleErrors(tweetError);
		}
		catch(Exception otherError)
		{
			baseController.handleErrors(otherError);
		}
	}
	
	public String getMostPopularWord(String username)
	{
		gatherTheTweets(username);
		removeBoringWords();
		removeBlankWords();
		
		String information = "The tweetCount is " + allTheTweets.size() + " and the word count after removal is " + tweetedWords.size();
		
		return information;
	}
	
	private void turnTweetsToWords()
	{
		for(Status currentTweet : allTheTweets)
		{
			String text = currentTweet.getText();
			String [] tweetWords = text.split(" ");
			for(String word : tweetWords)
			{
				tweetedWords.add(word);
			}
		}
	}
	
	private String [] createIgnoredWordsArray()
	{
		String [] boringWords;
		int wordCount = 0;
		
		Scanner boringWordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		while(boringWordScanner.hasNextLine())
		{
			boringWordScanner.nextLine();
			wordCount++;
		}
		boringWordScanner.close();
		
		boringWords = new String [wordCount];
		
		boringWordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		
		for(int index = 0; index < boringWords.length; index++)
		{
			boringWords[index] = boringWordScanner.next();
		}
		boringWordScanner.close();
			
		return null;
	}
	
	private void removeBoringWords()
	{
		String [] boringWords = createIgnoredWordsArray();
		
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			for(int boringIndex = 0; boringIndex < boringWords.length; boringIndex++)
			{
				if(tweetedWords.get(index).equalsIgnoreCase(boringWords[boringIndex]))
				{
					tweetedWords.remove(index);
					index--;
					boringIndex = boringWords.length;
				}
			}
		}
	}
	private void removeBlankWords()
	{
		for(int index = 0; index < tweetedWords.size(); index ++)
		{
			if(tweetedWords.get(index).trim().equals(""))
			{
				tweetedWords.remove(index);
				index--;
			}
		}
	}

	private void gatherTheTweets(String user)
	{
		tweetedWords.clear();
		allTheTweets.clear();
		int pageCount = 1; 
		Paging statusPage = new Paging(1, 200);
		
		while(pageCount <= 10)
		{
			try
			{
			allTheTweets.addAll(twitterBot.getUserTimeline(user, statusPage));
			}
			catch(TwitterException twitterError)
			{
				baseController.handleErrors(twitterError);
			}
				pageCount++;
		}
		
	}
	
	private String calculateTopWord()
	{
		String results = ""; 
		String topWord = "";
		int mostPopularIndex = 0;
		int popularCount = 0;
		
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			for(int searched = index + 1; searched < tweetedWords.size(); searched++)
			{
				int currentPopularity = 0;
				if(tweetedWords.get(index).equalsIgnoreCase(tweetedWords.get(searched)))
				{
					currentPopularity++;
				}
			}
			if(currentPopularity > popularCount)
			{
				popularCount = currentPopularity;
				mostPopularIndex = index;
				topWord= tweetedWords.get(mostPopularIndex);
			}
		}
		results += " the most popular word was " + topWord + ", and it occurred " + popularCount + " times.";
		results =+ "\nThat means it has a percentage of " + ((double)popularCount)/tweetedWords.size() + "%";
		
		return results;
	}
}
