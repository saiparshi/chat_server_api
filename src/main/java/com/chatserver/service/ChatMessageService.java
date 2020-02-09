package com.chatserver.service;

import com.chatserver.model.ChatMessage;
import com.chatserver.model.User;
import com.chatserver.model.UserRequest;
import com.chatserver.repository.ChatMessageRepository;
import com.chatserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public List<ChatMessage> getChatMessagesByTopic(String topic){
        return chatMessageRepository.findChatMessageByTopicName(topic);
    }

    public List<ChatMessage> getChatMessagesByUser(String fromUser){
        return chatMessageRepository.findChatMessageByFrom(fromUser);
    }

    public List<ChatMessage> getChatMessagesInsertedByUserOnTopic(String fromUser, String topic){
        return chatMessageRepository.findChatMessageByFromAndTopicName(fromUser, topic);
    }

    public List<ChatMessage> getChatMessagesReceivedBy(String toUser){
        return chatMessageRepository.findChatMessageByTo(toUser);
    }

    public ChatMessage saveMessage(ChatMessage message){
        return chatMessageRepository.save(message);
    }
}
