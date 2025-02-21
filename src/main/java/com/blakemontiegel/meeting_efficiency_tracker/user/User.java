package com.blakemontiegel.meeting_efficiency_tracker.user;

import com.blakemontiegel.meeting_efficiency_tracker.meeting.Meeting;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false, unique = true)
        private String email;

        @Column(nullable = false)
        private String password;

        @Enumerated(EnumType.STRING)
        private Role role;

        @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Meeting> meetings;

//        public Long getId() {
//                return id;
//        }
//
//
//        public String getEmail() {
//                return email;
//        }
//

        @Override
        public String getUsername() {
                return username;
        }
        @Override
        public String getPassword() {
                return password;
        }
        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of(new SimpleGrantedAuthority(role.name()));
        }


//        public List<Meeting> getMeetings() {
//                return meetings;
//        }
//
//        public void setPassword(String encode) {
//                this.password = encode;
//        }

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

