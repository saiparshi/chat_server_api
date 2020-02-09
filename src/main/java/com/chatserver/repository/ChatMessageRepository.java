package com.chatserver.repository;

import com.chatserver.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ChatMessageRepository extends MongoRepository<ChatMessage, Long> {
    List<ChatMessage> findChatMessageByFrom(String userName);
    List<ChatMessage> findChatMessageByFromAndTopicName(String userName, String topicName);
    List<ChatMessage> findChatMessageByTo(String userName);
    List<ChatMessage> findChatMessageByTopicName(String topicName);
    List<ChatMessage> findChatMessageByCreatedTimeBetween(LocalDateTime startTime, LocalDateTime endTime);
}
