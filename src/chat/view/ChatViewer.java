package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class ChatViewer
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatViewer()
	{
		windowMessage = "This message rough to you by the chatbot! :D ";
		chatIcon = new ImageIcon(getClass().getResource("images/chatbot.png"));
	}

	public String collectResponse(String Question)
	{
		String response = "";
		
		response = JOptionPane.showInputDialog(null, Question);
		
		return response;
	}
	
	public int collectUserOption(String question)
	{
		int response = 0;
		
		response = JOptionPane.showConfirmDialog(null, question);
		
		return response; 
	}
	
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null,  message);
	}
}

