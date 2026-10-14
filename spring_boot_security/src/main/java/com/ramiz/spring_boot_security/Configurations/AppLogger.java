package com.ramiz.spring_boot_security.Configurations;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class AppLogger {
     @EventListener
    public void loginSuccess(AuthenticationSuccessEvent event) {
        log.info("Login successful: {}", event.getAuthentication().getName());
        System.out.println("Login successful");
    }

    @EventListener
    public void loginFailed(AbstractAuthenticationFailureEvent event) {
        log.warn("Login failed: {}", event.getAuthentication().getName());
        System.out.println("login failed");
    }

    public void dataSaved(String username) {
        log.info("Data saved: user={}", username);
        System.out.println("data saved successfully");
    }

    public void dataSaveFailed(String username, Exception ex) {
        log.error("Failed to save data: user={}", username, ex);
        System.out.println("failed to save ");
    }
}
