package com.rahul.spliteasy.service.interfaces;

import com.rahul.spliteasy.persistence.dto.user.AuthenticationResponse;
import com.rahul.spliteasy.persistence.dto.user.LoginRequest;
import com.rahul.spliteasy.persistence.dto.user.RefreshTokenRequest;

public interface AuthService {
    public AuthenticationResponse authenticateUser(LoginRequest loginRequest);
    public AuthenticationResponse issueNewToken(RefreshTokenRequest refreshTokenRequest);
}
