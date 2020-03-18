package org.messages.MessagingQueue.Controller;

public interface MessagingService {
      
	 boolean addToQueue();
	 
	 MessageEntity takeFromQueue();
}
