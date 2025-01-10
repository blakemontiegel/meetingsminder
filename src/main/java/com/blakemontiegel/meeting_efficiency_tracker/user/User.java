package com.blakemontiegel.meeting_efficiency_tracker.user;

import com.blakemontiegel.meeting_efficiency_tracker.meeting.Meeting;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false, unique = true)
        private String email;

        @Column(nullable = false)
        private String password;

        @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Meeting> meetings;

        public Long getId() {
                return id;
        }

        public String getUsername() {
                return username;
        }

        public String getEmail() {
                return email;
        }

        public String getPassword() {
                return password;
        }

        public List<Meeting> getMeetings() {
                return meetings;
        }

        @Override
        public String toString() {
                return "User{" +
                        "id=" + id +
                        ", username='" + username + '\'' +
                        ", email='" + email + '\'' +
                        ", password='" + password + '\'' +
                        '}';
        }
}

