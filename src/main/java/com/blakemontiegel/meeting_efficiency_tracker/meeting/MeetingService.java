package com.blakemontiegel.meeting_efficiency_tracker.meeting;

import com.blakemontiegel.meeting_efficiency_tracker.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeetingService {

    private MeetingRepository meetingRepository;

    public Meeting getMeetingById(String id) {
        Optional<Meeting> meeting = meetingRepository.findById(id);
        if(meeting.isEmpty()) {
            throw new MeetingNotFoundException();
        }
        return meeting.get();
    }

    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    public void saveMeeting(Meeting meeting) {
        meetingRepository.save(meeting);
    }
}
