package com.jagan.expensetracker.controller;

import com.jagan.expensetracker.dto.AuthRequest;
import com.jagan.expensetracker.dto.AuthResponse;
import com.jagan.expensetracker.dto.RegisterRequest;
import com.jagan.expensetracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest req) {
        userService.register(req);
        return ResponseEntity.ok("User registered");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest req) {
        return ResponseEntity.ok(userService.login(req));
    }
}
