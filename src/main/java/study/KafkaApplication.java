package study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
@SpringBootApplication
public class KafkaApplication {
    @KafkaListener(topics = "messageTopic")
    public void msgListener(String messageId, String message) {
        System.out.println("messageId='" + messageId + "' message='" + message + "'");
    }
    
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }
}
