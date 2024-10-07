package com.example.core.configuration;

import com.example.core.dto.request.UserDto;
import com.example.core.entity.User;
import com.example.core.service.UserService;
import liquibase.util.ObjectUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.Iterator;

import static com.example.core.constains.Constains.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService, InitializingBean {

    private final UserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userService.getUserByUsername(username);
        if (ObjectUtils.isEmpty(userDto)){
            throw new UsernameNotFoundException(USER_NOT_FOUND);
        }
        User user = userDto.toEntity();

        Collection<? extends GrantedAuthority> cols = user.getAuthorities();
        Iterator iAuthority = cols.iterator();

        while (iAuthority.hasNext()){
            GrantedAuthority grantedAuthor = (GrantedAuthority) iAuthority.next();
            user.getAuthorities().add(grantedAuthor);
        }
        return user;
    }
}