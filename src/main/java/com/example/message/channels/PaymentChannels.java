package com.example.message.channels;

import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;
import org.springframework.cloud.stream.annotation.Output;

@Component
public interface PaymentChannels {

	@Output 
	MessageChannel paymetnConsumerChannel();
}
