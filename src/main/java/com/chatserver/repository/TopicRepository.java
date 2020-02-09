package com.chatserver.repository;

import com.chatserver.model.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends MongoRepository<ChatRoom, Long> {
    ChatRoom findByName(String topicName);
}
