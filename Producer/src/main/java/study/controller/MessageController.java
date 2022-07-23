package study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.service.SendService;

@RestController
@RequestMapping("message")
public class MessageController {

    private final SendService sendService;

    @Autowired
    public MessageController(SendService sendService) {
        this.sendService = sendService;
    }

    @PostMapping
    public void sendOrder(String messageId, String message) {
        sendService.sendMessage("MESSAGE ID=" + messageId + " MESSAGE=" + message);
    }
}
