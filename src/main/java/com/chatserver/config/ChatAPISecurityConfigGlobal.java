//package com.chatserver.config;
//
//import com.chatserver.service.ChatAPISecurityValidationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @Author: Sagarica Parshi
// * Global Security configuration class
// * Todo: Enable security after login is integrated with messaging
// */
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//@EnableWebSecurity
//@ComponentScan("com.chatserver")
//public class ChatAPISecurityConfigGlobal extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    ChatAPISecurityValidationService chatAPISecurityValidationService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //Todo: Enable below once login validation is integrated with messaging module
//        http
//                .authorizeRequests()
//                .antMatchers("/userInfo/login").permitAll()
//                .antMatchers(
//                        "/chat/**/**",
//                        "/userInfo/**",
//                        "/topicInfo/**",
//                        "/chatMessages/**",
//                        "/message/**").authenticated();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(chatAPISecurityValidationService);
//    }
//}
