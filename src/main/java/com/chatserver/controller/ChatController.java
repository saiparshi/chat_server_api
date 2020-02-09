package com.chatserver.controller;

import com.chatserver.model.ChatMessage;
import com.chatserver.model.Message;
import com.chatserver.model.OutputMessage;
import com.chatserver.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: Sagarica Parshi
 * ChatWebSocketController
 * Does message mapping to specific socket endpoint
 * Send responses to all the users subscribed to Specific topic
 * Todo: Use pub/sub for storing messages too to improve the performance
 */
@Controller
public class ChatController {

    @Autowired
    private ChatMessageService chatMessageService;

//    private SimpMessagingTemplate template;
//
//    @Autowired
//    public ChatController(SimpMessagingTemplate template) {
//        this.template = template;
//    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(final Message message) throws Exception {
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        chatMessageService.saveMessage(new ChatMessage(null, message.getFrom(),message.getText(), "messages", null, LocalDateTime.now()));
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }

    //Todo: Specific to room

    //    @MessageMapping("/room/{room}")
    //    @SendTo("/room/{room}")
    //    public void send(@DestinationVariable String room, final Message message) throws Exception {
    //        System.out.println("message:"+message.getFrom()+" text:"+message.getText());
    //        final String time = new SimpleDateFormat("HH:mm").format(new Date());
    //         chatMessageService.saveMessage(new ChatMessage(null, message.getFrom(),message.getText(), "messages", null, LocalDateTime.now()));
    //        this.template.convertAndSend("/room/"+room, new OutputMessage(message.getFrom(), message.getText(), time));
    //    }

}