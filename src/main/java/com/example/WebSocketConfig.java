package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Created by Catbat on 25.11.2016.
 */
@Configuration
@EnableWebSocketMessageBroker
public abstract class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("gs-guide-websocket").withSockJS();
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        config.setApplicationDestinationPrefixes("/app");
        config.enableSimpleBroker("/topic");
    }

    //Section 26.4.8 "Connections to Full-Featured Broker ; Section 26.4.10 "Authentication"
    //http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#websocket-fallback-sockjs-client
    //https://github.com/rstoyanchev/spring-websocket-portfolio/blob/master/src/test/java/org/springframework/samples/portfolio/web/load/StompWebSocketLoadTestClient.java
}
