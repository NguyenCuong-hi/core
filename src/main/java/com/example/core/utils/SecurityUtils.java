package com.example.core.utils;

import com.example.core.entity.Role;
import com.example.core.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

@RequiredArgsConstructor
public class SecurityUtils {

    public static boolean isAuthenticated(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !Objects.isNull(authentication) && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken);
    }

    public static boolean isUserInRole(User user, String role){

        if (Objects.isNull(user)){
            return false;
        }else {
            Set<GrantedAuthority> roles = (Set) user.getAuthorities();
            Iterator iRoles = roles.iterator();
            GrantedAuthority grantedAuthority;
            do {
                if (!iRoles.hasNext()){
                    return false;
                }
                grantedAuthority = (GrantedAuthority) iRoles.next();
            }while (!(grantedAuthority instanceof Role) || !grantedAuthority.equals(role));
            return true;
        }
    }

    public static User getCurrentUser(){
        if (!isAuthenticated()){
            return null;
        }else {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            return (User) auth.getPrincipal();
        }
    }

    public static void setCurrentUser(User user){
        Authentication auth = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    public static boolean passwordMatch(String encryptPassword, String plaintPassword){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(plaintPassword, encryptPassword);
    }
}
