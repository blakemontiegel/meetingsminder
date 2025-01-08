package com.blakemontiegel.meeting_efficiency_tracker.meeting;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting,String> {
}
