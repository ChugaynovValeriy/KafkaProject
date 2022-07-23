package study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static study.config.ProducerConfig.TOPIC_NAME;

@Service
public class SendServiceImpl implements SendService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public SendServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String message) {
        for (int i = 0; i < 10; i++) {
            System.out.println("IN PRODUCER MESSAGE=" + message + i);
            kafkaTemplate.send(TOPIC_NAME, message + i);
        }
    }
}
