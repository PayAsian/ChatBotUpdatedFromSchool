package chat.controller;

import chat.view.ChatFrame;
import chat.model.Chatbot;
import chat.view.*;

public class ChatbotController

{
	private Chatbot stupidBot;
	private ChatViewer display;
	
	
	public ChatbotController()
	{
		stupidBot = new Chatbot("Penguin's");
		display = new ChatViewer();
	}
	
	
	
	
	public void start()
	{
		
		String response = display.collectResponse("What do you want to talk aobut today?????");
		
		while(stupidBot.lengthChecker(response))
		{
			response = display.collectResponse("Oh, you are interested in " + response);
			
		}
	
	if("".equals(""))
		{
		
		}
		
	}
	
	
	public String useChatbotCheckers(String input)
	{
		String answer = "";
		
		if(stupidBot.contentChecker(input))
		{
			answer += "\nYou know my special scret\n";
		}
		if(stupidBot.memeChecker(input))
		{
			answer += "\nI can has memes?\n";
		}
		if(answer.length() == 0)
		{
			answer += "sorry, i dont know about " + input;
		}
		return answer;
	}
	
	public void setBaseFrame(String baseFrame)
	{
		
		this.setbaseFrame = new baseFrame;
	}
	
	public void handleErrors(Exception currentException)
	{
		display.displayMessage("An error has occurred. Details provided next.");
		display.displayMessage(currentException.getMessage());
	}

	
}
