package com.ilacad.blog.blogrestapi.service;

import com.ilacad.blog.blogrestapi.payload.LoginDto;
import com.ilacad.blog.blogrestapi.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
