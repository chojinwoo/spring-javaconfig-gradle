package com.spring.javaconfig.wa.users.dao;

import com.spring.javaconfig.wa.users.entity.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by bangae1 on 2016-01-11.
 */
public interface UsersDao {
    public Users loadUserByUsername(String username) throws UsernameNotFoundException;
}
