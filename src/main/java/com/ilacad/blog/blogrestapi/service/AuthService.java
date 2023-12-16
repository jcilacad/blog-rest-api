package com.ilacad.blog.blogrestapi.service;

import com.ilacad.blog.blogrestapi.payload.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
