package com.blakemontiegel.meeting_efficiency_tracker.meeting;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MeetingNotFoundException extends RuntimeException{
    public MeetingNotFoundException() {
        super("Meeting not found");
    }

}
