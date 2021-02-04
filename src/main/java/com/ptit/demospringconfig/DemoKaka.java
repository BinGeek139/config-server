package com.ptit.demospringconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DemoKaka {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send("demo", msg);
    }

    @KafkaListener(topics = "demo", groupId = "group-id")
    public void listen(String message) {
        System.out.println("Received Message in group - group-id: " + message);
    }

    public void run()  {
        try {
            for (int i = 0; i < 1000; i++) {
                String message="Now: " + new Date();
                sendMessage(message);
                System.out.println("sendMessage: "+ message);
                Thread.sleep(2000);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
