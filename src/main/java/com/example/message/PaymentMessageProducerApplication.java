package com.example.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.example.message.channels.PaymentChannels;

@SpringBootApplication
@EnableBinding(PaymentChannels.class)
public class PaymentMessageProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentMessageProducerApplication.class, args);
	}
}
