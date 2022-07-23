package study;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@EnableKafka
public class ConsumerConfig {

    private static final String GROUP1_ID = "group1";
    private static final String GROUP2_ID = "group2";

    private static final String TOPIC_NAME = "my_topic";

    @KafkaListener(groupId = GROUP1_ID, topics = TOPIC_NAME, id = "l1_1")
    public void listenGroup1Partition1(String message) {
        System.out.println("IN GROUP1 PART1 LISTENER MESSAGE=" + message);
    }

    @KafkaListener(groupId = GROUP1_ID, topics = TOPIC_NAME, id = "l1_2")
    public void listenGroup1Partition2(String message) {
        System.out.println("IN GROUP1 PART2 LISTENER MESSAGE=" + message);
    }

    @KafkaListener(groupId = GROUP2_ID, topics = TOPIC_NAME, id = "l2_1")
    public void listenGroup2(String message) {
        System.out.println("IN GROUP2 LISTENER MESSAGE=" + message);
    }
}
