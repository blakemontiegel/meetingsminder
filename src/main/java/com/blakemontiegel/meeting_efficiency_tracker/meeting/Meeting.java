package com.blakemontiegel.meeting_efficiency_tracker.meeting;

import com.blakemontiegel.meeting_efficiency_tracker.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "meetings")
public class Meeting {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = false)
    private User organizer;
    @Column(nullable = false)
    private LocalDateTime startTime;
    @Column(nullable = false)
    private LocalDateTime endTime;

    @Positive
    private BigDecimal cost;

    @Positive
    private Integer numOfParticipants;



}
