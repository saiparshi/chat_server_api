package com.chatserver.controller;

import com.chatserver.model.ChatMessage;
import com.chatserver.service.ChatMessageService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @Author: Sagarica Parshi
 * Controller to specific user client, server web socket handshake
 */
@Controller
public class WebSocketQueueController {

    @Autowired
    private ChatMessageService chatMessageService;

    private Gson gson = new Gson();

    @MessageMapping("/message")
    @SendToUser("/queue/reply")
    public String processMessageFromClient(@Payload String message, Principal principal) throws Exception {
        String from = gson.fromJson(message, Map.class).get("name").toString();
        chatMessageService.saveMessage(new ChatMessage(null, from, message, null, principal.getName(), LocalDateTime.now()));
        return from;
    }

    @MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }
}
