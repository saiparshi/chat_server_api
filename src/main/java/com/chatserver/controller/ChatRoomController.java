package com.chatserver.controller;

import com.chatserver.model.ChatRoom;
import com.chatserver.model.ChatRoomRequest;
import com.chatserver.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Sagarica Parshi
 * Rest Controller to CURD on Topics
 */
@RestController
@RequestMapping(value = "/rooms")
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private List<ChatRoom> getTopics(){
        return chatRoomService.getAllTopics();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    private String saveTopic(@RequestBody ChatRoomRequest topic){
        chatRoomService.createTopic(topic);
        return "Successful";
    }

    @RequestMapping(value = "/{topicName}", method = RequestMethod.DELETE)
    private String deleteTopic(@PathVariable String topicName){
        chatRoomService.deleteTopic(topicName);
        return "Successful";
    }
}
