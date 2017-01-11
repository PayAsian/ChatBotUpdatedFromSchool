package chat.model;

import java.util.ArrayList;
import chat.tests.ChatbotTest;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part 
 * * of the project. 
 * * @author Peyton Trevino 
 * * @version 1.0 10/14/16
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	private String buildMemeslist;
	private String buildPoliticalTopicList;
	private String memeChecker;
	private String politicalTopicChecker;
	private boolean looksTweetable;

	

	/**
	 * * Creates an instance of the Chatbot with the supplied username. 
	 * * @param
	 * userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.politicalTopicList = new ArrayList<String>();
		this.memesList = new ArrayList<String>();
		this.userName = new String(userName);
		this.content = new String("Snowboarding");
		this.buildMemeslist = new String();
		this.buildPoliticalTopicList = new String();
		this.politicalTopicChecker = new String();
		this.memeChecker = new String();
		this.looksTweetable = false;
		
	
	}

	private boolean buildMemeslist(boolean memesList)
	{
		boolean MemesList = false;
		if(buildMemeslist !=null && getMemesList().size() > 17 )
		{
			MemesList = false; 
		}
		return MemesList;
		
	}
	
	

	private boolean buildPoliticalTopicList(boolean politicalTopicList)
	{
		boolean PoliticalTopicList = false;
		
		if(buildPoliticalTopicList !=null && getPoliticalTopicList().size() > 18)
		{
			PoliticalTopicList = true; 
		}
		return PoliticalTopicList;
	}

	/**
	 * * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true. * @param currentInput * @return
	 * A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if (currentInput !=null && currentInput.length() > 0)
		{
			hasLength = true;
		}
		return hasLength;
	}

	/**
	 * * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether it
	 *            matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false; 
		
		if(currentInput.contains(content))
		{
			hasContent = true;
		}
		
		return hasContent;
	}

	/**
	 * * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. *
	 *             @return Whether the
	 *            String is contained in the ArrayList.
	 */

	public boolean politicalTopicChecker(String politicalTopicList)
	{
		boolean haspoliticalTopicChecker = false;
		
		if(politicalTopicChecker.contains(politicalTopicList))
		{
			haspoliticalTopicChecker = true;
		}
		
		return haspoliticalTopicChecker;
	}
	
	public boolean quitChecker(String currentInput)
	{
		boolean hasQuit = false;
		
		if(currentInput.equalsIgnoreCase("quit"))
		{
			hasQuit = true;
		}
		else if(currentInput.equalsIgnoreCase("Exit"))
		{
			hasQuit = false;
		}
		
		return hasQuit;
	}
	
	public boolean keyBoardMashChecker(String currentInput)
	{
		boolean hasKeyBoardMash = false;
		
		
		if(currentInput.equalsIgnoreCase("S.D.F."))
		{
			hasKeyBoardMash = false;
		}
		else if(currentInput.equalsIgnoreCase("derf"))
		{
			hasKeyBoardMash = false;
		}
		else if(currentInput.equalsIgnoreCase("sdf"))
		{
			hasKeyBoardMash = true;
		}
		else if(currentInput.equalsIgnoreCase("dfg"))
		{
			hasKeyBoardMash = true;
		}
		else if(currentInput.equalsIgnoreCase("cvb"))
		{
			hasKeyBoardMash = true;
		}
		else if(currentInput.equalsIgnoreCase(",./"))
		{
			hasKeyBoardMash = true;
		}
		
		return hasKeyBoardMash;
	}

	/**
	 * * Checks to see that the supplied String value is in the current
	 * memesList variable.
	 * @param currentInput
	 * The supplied String to be checked. 
	 * * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String memesChecker)
	{
		
		boolean hasmemeChecker = false;
		
		if(memeChecker.equals("doge"))
		{
			hasmemeChecker = true;
		}
		else if(memeChecker.equals("cute animals"))
		{
			hasmemeChecker = true;
		}
		
		return hasmemeChecker;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	/**
	 * * Returns the username of this Chatbot instance. * @return The username
	 * of the Chatbot.
	 */
	public String getUserName()
	{
		return null;
	}

	/**
	 * * Updates the content area for this Chatbot instance. 
	 * * @param content
	 * The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
	
	/**
	 * * Returns the content area for this Chatbot instance. * @return The
	 * content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	public void setMemesList(ArrayList<String> memesList)
	{
		this.memesList = memesList;
	}

	/**
	 * * Getter method for the memesList object. 
	 * * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
	
		return memesList;
	}
	
	public void setpoliticalTopiclist(ArrayList<String>politicalTopicList)
	{
		this.politicalTopicList = politicalTopicList;
	}

	/**
	 * * Getter method for the politicalTopicList object. 
	 * * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}

	
	
	public boolean twitterChecker(String input)
	{
		boolean looksTweetable = false;
		if(input == null)
		{
			return false;
		}
		
		int indexOfHash = input.indexOf("#");
		int indexOfAt = input.indexOf("@");
		
		if(indexOfHash >= 0 || indexOfAt >= 0)
		{
			if(indexOfHash != - 1)
			{
				if(!input.substring(indexOfHash + 1, indexOfHash +2).equals(" "))
				{
					looksTweetable = true;
				}
			}
			if(indexOfAt > -1)
			{
				if(input.indexOf(" ", indexOfAt) != indexOfAt+1)
				{
					looksTweetable = true;
				}
			}
		}
		return looksTweetable = true;
	}
	
	public boolean inputHTMLChecker(String input)
	{
		boolean containsHTML = false;
		
		if(input == null || !input.contains("<"))
		{
			return containsHTML;
		}
		
		int firstOpen = input.indexOf("<");
		int firstClose = input.indexOf("> ",firstOpen);
		int secondOpen = -9;
		int secondClose = -9;
		String tagText = "";
		
		if(input.contains("<>") || input.indexOf("< >") > -1)
		{
			containsHTML = false;
		}
		if(input.toUpperCase().contains("<P>") || input.toLowerCase().contains("<br>"))
		{
			containsHTML = true;
		}
		else if (firstClose > firstOpen)
			{
				tagText = input.substring(firstOpen + 1, firstClose).toLowerCase();
				secondOpen = input.toLowerCase().indexOf("</" + tagText, firstClose);
			
				if(tagText.contains("a href=\""))
				{
					if(tagText.indexOf("\"", firstOpen+10) >= 0)
					{
						String remainder = input.substring(firstClose);
						if(remainder.indexOf("</a>") >= 0)
						{
							containsHTML = true;
						}
						
					}
				}
				else if(secondOpen >= 0)
				{
					secondClose = input.indexOf(">", secondOpen + tagText.length());
					String closingTag = input.toLowerCase().substring(secondOpen+2,secondClose);
					if(secondClose >= 0 && closingTag.equals(tagText))
					{
						containsHTML = true;
					}
					else
					{
						containsHTML = false;
					}
				}
				else 
				{
					containsHTML = false;
				}
					
			}
		
		return containsHTML;
	}
	

}