package chat.view;

import javax.swing.JFrame;
import java.awt.Dimension;
import chat.controller.ChatbotController;

public class ChatFrame extends JFrame
{
	private ChatbotController baseController;
	private ChatPanel apppanel;
	
	public ChatFrame(ChatbotController baseController)
	{
		super();
		this.baseController = baseController;
		this.apppanel = new ChatPanel(baseController);
		
		this.setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(apppanel);
		this.setTitle("");
		this.setSize(new Dimension(600, 400));
		this.setVisible(true);
	}
}
