package com.example.demo.controller;

import com.example.demo.dto.LoginRequestDto;
import com.example.demo.dto.RegistrationDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationDto registrationDto) {
        if (userRepository.findByUsername(registrationDto.getUsername()).isPresent()) {
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.findByEmail(registrationDto.getEmail()).isPresent()) {
            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
        }
        User userToRegister = new User(registrationDto.getUsername(), registrationDto.getEmail(), registrationDto.getPassword(), registrationDto.getFirstName(), registrationDto.getLastName());
        User registeredUser = userService.registerUser(userToRegister);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/login")
    public String showLoginForm() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:static/login.html");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request, HttpServletResponse response) {
        Optional<User> userOptional = userService.loginUser(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        if (userOptional.isPresent()) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", userOptional.get());
            refreshSessionCookie(request, response);
            return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/main.html").build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            Cookie sessionCookie = new Cookie("SESSIONID", null);
            sessionCookie.setPath("/");
            sessionCookie.setHttpOnly(true);
            sessionCookie.setMaxAge(0);
            sessionCookie.setSecure(true);
            response.addCookie(sessionCookie);
            response.sendRedirect("login.html");
        }
    }

    @GetMapping("/api/userinfo")
    public ResponseEntity<String> getCurrentUserName(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            return ResponseEntity.ok(user.getUsername());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }
    }

    @GetMapping("/api/isLoggedIn")
    public ResponseEntity<Boolean> isLoggedIn(HttpSession session) {
        boolean isLoggedIn = session != null && session.getAttribute("user") != null;
        return ResponseEntity.ok(isLoggedIn);
    }


    private void refreshSessionCookie(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            request.changeSessionId();
            Cookie sessionCookie = new Cookie("SESSIONID", session.getId());
            sessionCookie.setHttpOnly(true);
            sessionCookie.setSecure(request.isSecure());
            sessionCookie.setMaxAge(7 * 24 * 60 * 60);
            sessionCookie.setPath("/");
            response.addCookie(sessionCookie);
        }
    }
}