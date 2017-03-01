package timer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;
import timer.domain.ReminderMessage;

/**
 * Created by mjrt on 2/24/2017.
 */
@RestController
public class WebSocketApi {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/chat")
    public ReminderMessage sendMessage(ReminderMessage message) throws Exception {
        Thread.sleep(200);

//        String address = "";

        System.out.println("******"+message.getMessage());
        return message;
//
//        template.convertAndSend(address,message);
    }
}
