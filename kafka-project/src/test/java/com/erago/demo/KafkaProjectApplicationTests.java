package com.erago.demo;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.test.context.junit4.SpringRunner;

import com.erago.demo.kafka.KafkaProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableKafka
public class KafkaProjectApplicationTests {

	
	@Autowired
	private KafkaProducer producer;
	
	public void contextLoads() {
	}
	
	@Test
	public void testGenerate(){
		List<String> msg = Arrays.asList("m1", "m2", "m3", "m4", "m5");
		producer.send("topic5Name", msg);
		System.out.println("waiting...");
	}

}