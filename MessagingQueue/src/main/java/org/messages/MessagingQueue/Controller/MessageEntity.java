package org.messages.MessagingQueue.Controller;

public class MessageEntity {
   
	private int messageId;
	private String message;
	
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "MessageEntity [messageId=" + messageId + ", message=" + message + "]";
	}
	
	
}
