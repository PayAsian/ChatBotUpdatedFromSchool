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

	public ChatPanel(ChatbotController baseController)
	{
		super();
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatDisplay = new JTextArea(5, 25);
		chatField = new JTextField(25);
		chatButton = new JButton("Chat with the bot");
		
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
		this.add(chatField);
	}
	
	private void setupLayout()
	{
		
		baseLayout.putConstraint(SpringLayout.NORTH, chatDisplay, 65, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatDisplay, -72, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatField, 22, SpringLayout.SOUTH, chatDisplay);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatDisplay);
		baseLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatDisplay);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 145, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -6, SpringLayout.NORTH, chatDisplay);
		
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
