package com.example.demo.consume;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class UserLogConsumer {
	
	protected Logger log = LoggerFactory.getLogger(UserLogConsumer.class);
	
	@KafkaListener(topics = {"user-log"})
    public void consumer(ConsumerRecord<?,?> consumerRecord) throws Exception{
		Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
		log.info(">>>>>>>>>> record =" + kafkaMessage);
        if(kafkaMessage.isPresent()){
            //得到Optional实例中的值
            Object message = kafkaMessage.get();
            System.err.println("消费消息:"+message);
        }
	}
}
