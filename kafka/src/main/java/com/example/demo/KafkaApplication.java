package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.demo.producer.UserLogProducer;

@SpringBootApplication
//@EnableKafka
@EnableScheduling
public class KafkaApplication {

	
	@Autowired
    private UserLogProducer kafkaSender;
    @PostConstruct
    public void init(){
        for (int i = 0; i < 10; i++) {
            //调用消息发送类中的消息发送方法
            kafkaSender.sendLog(String.valueOf(i));
        }
    }
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

}
