package org.messages.MessagingQueue.Controller;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Component;

@Component
public class CustomQueue {
   
	private BlockingQueue<MessageEntity> messageQueue;
	
	public CustomQueue(int capacity) {
		messageQueue = new LinkedBlockingQueue<MessageEntity>();
	}
	
	public boolean add(MessageEntity messageEntity) {
		return this.messageQueue.offer(messageEntity);
	}
	
	public MessageEntity take() {
		return this.messageQueue.poll();
	}
}
