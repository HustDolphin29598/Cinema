package com.onemount.cinema.service;

import com.onemount.cinema.model.CustomUserDetails;
import com.onemount.cinema.model.User;
import com.onemount.cinema.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        User user = userRepository.findByPhone(phone);
        if (user == null) {
            throw new UsernameNotFoundException(phone);
        }
        return new CustomUserDetails(user);
    }

    public UserDetails getUserById(int userId){
        User user = userRepository.findById(userId);
        return new CustomUserDetails(user);
    }

    public User getUserByPhone(String phone){
        User user = userRepository.findByPhone(phone);
        if (user == null) {
            throw new UsernameNotFoundException(phone);
        }
        return user;
    }
}
