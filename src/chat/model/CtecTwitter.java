package chat.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import chat.controller.ChatbotController;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;
import twitter4j.Status;

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
	
	public String getMostPopularWord()
	{
		removeBoringWords();
		removeBlankWords();
		
		return "";
	}
	
	private String [] createIgnoredWordsArray()
	{
		String [] boringWords;
		int wordCount = 0;
		
		Scanner boringWordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		while(boringWordScanner.hasNextLine())
		{
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
				blankIndex = blankWords.length;
			}
		}
	}
	
}
