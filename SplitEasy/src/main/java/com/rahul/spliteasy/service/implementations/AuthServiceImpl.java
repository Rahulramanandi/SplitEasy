package com.rahul.spliteasy.service.implementations;

import com.rahul.spliteasy.configuration.jwt.JwtUtil;
import com.rahul.spliteasy.exception.BadRequestException;
import com.rahul.spliteasy.exception.DataNotFoundException;
import com.rahul.spliteasy.persistence.dto.user.AuthenticationResponse;
import com.rahul.spliteasy.persistence.dto.user.LoginRequest;
import com.rahul.spliteasy.persistence.dto.user.RefreshTokenRequest;
import com.rahul.spliteasy.persistence.entities.User;
import com.rahul.spliteasy.repository.UserRepository;
import com.rahul.spliteasy.service.interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse authenticateUser(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getUserEmail()).orElseThrow(() -> new DataNotFoundException("User not found."));
        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new BadRequestException("Invalid User mail or password!");
        }
        String token = jwtUtil.generateAccessToken(user);
        String refreshToken = jwtUtil.generateRefreshToken(user);
        return new AuthenticationResponse(token, refreshToken, "Successfully generated token!");
    }

    @Override
    public AuthenticationResponse issueNewToken(RefreshTokenRequest refreshTokenRequest) {
        String userId = jwtUtil.getClaimsOfRefreshToken(refreshTokenRequest.getRefreshToken()).getSubject();
        User user = userRepository.findByEmail(userId).orElseThrow(() -> new DataNotFoundException("User not found."));
        String accessToken = jwtUtil.generateAccessToken(user);
        String refreshToken = jwtUtil.generateRefreshToken(user);
        return new AuthenticationResponse(accessToken, refreshToken, "Successfully generated token from refresh!");
    }
}
