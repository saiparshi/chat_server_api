package com.chatserver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @Author: Sagarica Parshi
 * Mongo collection for storing chat messages from client and server handshake
 */
@Document(collection = "ChatMessage")
public class ChatMessage {

    @Id
    private String id;
    private String from;
    private String text;
    private String topicName;
    private String to;

    public ChatMessage(String id, String from, String text, String topicName, String to, LocalDateTime createdTime) {
        this.id = id;
        this.from = from;
        this.text = text;
        this.topicName = topicName;
        this.to = to;
        this.createdTime = createdTime;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setText(String text) {
        this.text = text;
    }
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    private LocalDateTime createdTime;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public String getFrom() {
        return from;
    }
}