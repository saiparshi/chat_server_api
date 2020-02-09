package com.chatserver.service;

import com.chatserver.model.User;
import com.chatserver.model.UserRequest;
import com.chatserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(boolean isActive){
        if(isActive){
            return userRepository.findUsersByLoggedInTrue();
        }
        return userRepository.findAll();
    }

    public User getSpecificUser(String userName){
        return userRepository.findByUserName(userName);
    }

    public User createUser(UserRequest user){
        User extObject = userRepository.findByUserName(user.getUserName());
        if(extObject!=null){
            return userRepository.save(extObject);
        }else{
            return userRepository.save(new User(
                    null,
                    user.getUserName(),
                    user.getPassword(),
                    false
            ));
        }
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(String userName) {
        User existingObj = userRepository.findByUserName(userName);
        userRepository.delete(existingObj);
    }

    public void enableLoginForUser(UserRequest user) {
        User existingObj = userRepository.findByUserName(user.getUserName());
        existingObj.setLoggedIn(true);
        userRepository.save(existingObj);
    }

    public void userLogout(UserRequest user) {
        User existingObj = userRepository.findByUserName(user.getUserName());
        existingObj.setLoggedIn(false);
        userRepository.save(existingObj);
    }
}
