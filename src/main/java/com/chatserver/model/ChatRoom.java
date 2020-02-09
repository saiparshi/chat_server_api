package com.chatserver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @Author: Sagarica Parshi
 * Mongo collection for Topic CURD
 */
@Document(collection="ChatRoom")
public class ChatRoom {
    @Id
    private String id;
    private String name;
    private List<String> usersSubscribed;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Can be expanded to capture created date and Time fields

    public ChatRoom(String name){
        this.name = name;
    }


    public List<String> getUsersSubscribed() {
        return usersSubscribed;
    }

    public void setUsersSubscribed(List<String> usersSubscribed) {
        this.usersSubscribed = usersSubscribed;
    }
}
