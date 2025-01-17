package com.blakemontiegel.meeting_efficiency_tracker.authentication;

import com.blakemontiegel.meeting_efficiency_tracker.user.User;

public class AuthResponse {
    private String token;
    private User user;

    public AuthResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }
    public User getUser() {
        return user;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
