package com.chatserver.repository;

import com.chatserver.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    User findByUserName(String userName);
    List<User> findUsersByLoggedInTrue();
}
