package com.chatserver.service;

import com.chatserver.model.ChatRoom;
import com.chatserver.model.ChatRoomRequest;
import com.chatserver.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatRoomService {

    @Autowired
    private TopicRepository topicRepository;

    public List<ChatRoom> getAllTopics(){
        return topicRepository.findAll();
    }

    public ChatRoom createTopic(ChatRoomRequest topic){
            return topicRepository.save(new ChatRoom(
                    topic.getName()
            ));
    }

    public void deleteTopic(String topic) {
        ChatRoom existingObj = topicRepository.findByName(topic);
        topicRepository.delete(existingObj);
    }
}
