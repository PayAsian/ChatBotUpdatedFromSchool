package chat.view;

import chat.controller.ChatbotController;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatPanel extends JPanel
{
	private ChatbotController baseController;
	private SpringLayout baseLayout;
	private JTextArea chatDisplay;
	private JTextField chatField;
	private JButton chatButton;
	private JButton twitterButton;
	private JButton sendTweet;
	private JButton save;
	private JButton load;

	public ChatPanel(ChatbotController baseController)
	{
		super();
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatDisplay = new JTextArea(5, 25);
		chatField = new JTextField(25);
		chatButton = new JButton("Chat with the bot");
		twitterButton = new JButton();
		sendTweet = new JButton();
		save = new JButton();
		load = new JButton();
		
		
		
		setupChatDisplay();
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupChatDisplay()
	{
		chatDisplay.setEditable(false);
		chatDisplay.setEnabled(false);
		chatDisplay.setLineWrap(true);
		chatDisplay.setWrapStyleWord(true);
		
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.BLUE);
		this.add(chatDisplay);
		this.add(chatButton);
		this.add(twitterButton);
		this.add(sendTweet);
		this.add(save);
		this.add(load);
		this.add(chatField);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatDisplay, 23, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatDisplay, 78, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatField, 17, SpringLayout.SOUTH, chatDisplay);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 78, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatDisplay);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 6, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 0, SpringLayout.WEST, chatDisplay);
		baseLayout.putConstraint(SpringLayout.EAST, twitterButton, -72, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, twitterButton, 18, SpringLayout.SOUTH, sendTweet);
		baseLayout.putConstraint(SpringLayout.NORTH, sendTweet, 0, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.EAST, sendTweet, 0, SpringLayout.EAST, chatDisplay);
		baseLayout.putConstraint(SpringLayout.SOUTH, save, 0, SpringLayout.SOUTH, twitterButton);
		baseLayout.putConstraint(SpringLayout.EAST, save, -32, SpringLayout.WEST, twitterButton);
		baseLayout.putConstraint(SpringLayout.NORTH, load, 18, SpringLayout.SOUTH, chatButton);
		baseLayout.putConstraint(SpringLayout.EAST, load, -297, SpringLayout.EAST, this);
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userWords = chatField.getText();
				String botResponse = baseController.useChatbotCheckers(userWords);
				
				chatDisplay.setText("You said: " + userWords + "\n" + "ChatBot said: " + botResponse);
				chatField.setText("");
			}
		});
		}
	
}
