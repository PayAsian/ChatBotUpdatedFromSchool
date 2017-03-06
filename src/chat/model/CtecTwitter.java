package chat.model;

import chat.controller.ChatbotController;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;

public class CtecTwitter 
{
	private ChatbotController baseController;
	private Twitter twitterBot;
	
	public CtecTwitter(ChatbotController baseController)
	{
		this.baseController = baseController;
		twitterBot = TwitterFactory.getSingleton();
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
}
