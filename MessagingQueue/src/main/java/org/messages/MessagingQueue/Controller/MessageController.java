package org.messages.MessagingQueue.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/message")
@RestController
public class MessageController {
	
	
	
	@PostMapping("/add")
	public void addToQueue(@RequestBody MessageEntity messageEntity) {
		
	}
	
	@GetMapping("/take")
	public MessageEntity takeFromQueue() {
		return new MessageEntity();
	}
	
}