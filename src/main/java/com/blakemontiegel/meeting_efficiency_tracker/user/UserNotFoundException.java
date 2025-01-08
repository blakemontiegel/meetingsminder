package com.blakemontiegel.meeting_efficiency_tracker.user;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("User not found");
    }
}
