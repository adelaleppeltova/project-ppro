package com.example.projectppro.models.services;

import com.example.projectppro.models.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void create(UserDTO user, boolean isAdmin);

    UserDetails loadUserByUsername(String username);

}
