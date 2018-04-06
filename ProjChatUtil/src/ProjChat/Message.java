package ProjChat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.projChat.DB.ChatDB;
import br.com.projChat.entidade.Chat;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;


	private String user;
	private String message;
	
	private static List<Message> lstMessage = new ArrayList<Message>();

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Message(String user, String message) {
		this.user = user;
		this.message = message;
	}

	public static List<Message> getLstMessage() {
		return lstMessage;
	}

	public static void setLstMessage(Message msg) {
		
		lstMessage.add(msg);
		
		Chat chat = new Chat();		
		chat.Message(msg.getUser(), msg.getMessage());
		
		ChatDB cdb = new ChatDB();
		
		cdb.insert(chat);
		
	}
	
	
}
