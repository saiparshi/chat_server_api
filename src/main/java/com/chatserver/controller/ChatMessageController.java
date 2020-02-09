package com.chatserver.controller;

/**
 * @Author: Sagarica Parshi
 * Rest Controller to CURD on Chat Messages
 */

import com.chatserver.model.ChatMessage;
import com.chatserver.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/messages")
public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;

    @RequestMapping(value = "/room/{room}", method = RequestMethod.GET)
    private List<ChatMessage> getChatMessagesroom(@PathVariable String room){
        return chatMessageService.getChatMessagesByTopic(room);
    }

    @RequestMapping(value = "/from/{fromUser}", method = RequestMethod.GET)
    private List<ChatMessage> getChatMessagesByUser(@PathVariable String fromUser){
        return chatMessageService.getChatMessagesByUser(fromUser);
    }

    @RequestMapping(value = "/from/{fromUser}/room/{room}", method = RequestMethod.GET)
    private List<ChatMessage> getChatMessagesByUser(@PathVariable String fromUser, @PathVariable String room){
        return chatMessageService.getChatMessagesInsertedByUserOnTopic(fromUser, room);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    private String saveMessage(@RequestBody ChatMessage chatMessage){
        chatMessageService.saveMessage(chatMessage);
        return "Successful";
    }
}
