package com.example.message.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.message.channels.PaymentChannels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@RestController
public class GreetingController {

	private final MessageChannel consumerChannel;
	
	@Autowired
	public GreetingController(PaymentChannels consumerChannel) {
		this.consumerChannel = consumerChannel.paymetnConsumerChannel();
	}
	
	@PostMapping("/greeting/{name}")
	public void publishGreet(@PathVariable String name){
		String greeting = "Hello, " + name + "!";
		System.out.println(greeting);
		Message<String> message = MessageBuilder.withPayload(greeting).build();
		
		this.consumerChannel.send(message);
	}
	
}
