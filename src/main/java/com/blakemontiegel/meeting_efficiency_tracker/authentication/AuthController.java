package com.blakemontiegel.meeting_efficiency_tracker.authentication;

import com.blakemontiegel.meeting_efficiency_tracker.user.User;
import com.blakemontiegel.meeting_efficiency_tracker.user.UserService;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());

        if(user == null) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return ResponseEntity.of(Optional.of(new AuthResponse(token, user)));
    }
}
