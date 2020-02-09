package com.chatserver.controller;

import com.chatserver.model.User;
import com.chatserver.model.UserRequest;
import com.chatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Sagarica Parshi
 * Rest Controller to CURD on User Collection
 * Todo: Authentication of user on login. Also integrate with client, server user socket handshake for user registration
 * Todo: HTTPStatus Requests enhancements
 */
@RestController
@RequestMapping(value = "/userInfo")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private List<User> getUsers(){
        return userService.getUsers(false);
    }

    @RequestMapping(value = "/active", method = RequestMethod.GET)
    private List<User> getActiveUsers(){
        return userService.getUsers(true);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    private String saveUser(@RequestBody UserRequest user){
        userService.createUser(user);
        return "Successful";
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.PUT)
    private String updateUser(@PathVariable String userName, @RequestBody UserRequest user){
        userService.createUser(user);
        return "Successful";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    private String login(@RequestBody UserRequest user){
        userService.enableLoginForUser(user);
        return "Successful";
    }

    @RequestMapping(value="/logout", method = RequestMethod.POST)
    private String logout(@RequestBody UserRequest user){
        userService.userLogout(user);
        return "Successful";
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.DELETE)
    private String deleteUser(@PathVariable String userName){
        userService.deleteUser(userName);
        return "Successful";
    }
}
