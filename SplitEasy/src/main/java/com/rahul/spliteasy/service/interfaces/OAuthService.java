package com.rahul.spliteasy.service.interfaces;

import com.rahul.spliteasy.persistence.dto.user.AuthenticationResponse;

public interface OAuthService {
    public AuthenticationResponse handleCallback(String code, String state);
}
