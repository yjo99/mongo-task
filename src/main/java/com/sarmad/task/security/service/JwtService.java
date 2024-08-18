package com.sarmad.task.security.service;

import org.springframework.security.core.Authentication;


public interface JwtService {
    public String generateJwtToken(Authentication authentication);
    public String generateRefreshToken(String username);
    public String getUserNameFromJwtToken(String token);
    public boolean validateJwtToken(String authToken);

}
