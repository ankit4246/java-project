package com.ch.cbsmiddleware.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author bimal on 10/1/21
 * @project cbs-middleware
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AdminRepo adminRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.err.println("Email "+email);
        Admin admin =  adminRepo.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));

        System.out.println("Admin "+admin.getEmail()+" Password "+admin.getPassword());
        return new User(admin.getEmail(), admin.getPassword(), List.of(
                new SimpleGrantedAuthority("ADMIN")
        ));
    }
}
