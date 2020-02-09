//package com.chatserver.service;
//
//import com.chatserver.model.User;
//import com.chatserver.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
//@Service
//public class ChatAPISecurityValidationService implements AuthenticationProvider {
//
//    @Autowired
//    UserRepository userRepository;
//
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String password = authentication.getCredentials()
//                .toString();
//        User userFromDB = userRepository.findByUserName(username);
//
//        if (userFromDB!=null && userFromDB.getUserName().equals(username) && userFromDB.getPassword().equals(password)) {
//            return new UsernamePasswordAuthenticationToken
//                    (username, password, Collections.emptyList());
//        } else {
//            throw new
//                    BadCredentialsException("Not a valid user");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
