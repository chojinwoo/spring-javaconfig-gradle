package com.spring.javaconfig.wa.users.service;

import com.spring.javaconfig.wa.users.entity.Users;

/**
 * Created by bangae1 on 2016-01-11.
 */
public interface UsersService {
    public Users findEmail(String email);
}
