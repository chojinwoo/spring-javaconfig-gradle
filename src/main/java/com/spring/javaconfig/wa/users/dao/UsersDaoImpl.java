package com.spring.javaconfig.wa.users.dao;

import com.spring.javaconfig.wa.users.entity.Users;
import com.spring.javaconfig.wa.users.entity.UsersAuth;
import com.spring.javaconfig.wa.users.repository.UsersAuthRepository;
import com.spring.javaconfig.wa.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

/**
 * Created by bangae1 on 2016-01-11.
 */
@Repository
public class UsersDaoImpl implements UsersDao {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersAuthRepository usersAuthRepository;

    @Override
    public Users loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.getOne(username);
    }

    public Users save(Users user) {
        return this.usersRepository.save(user);
    }

    public UsersAuth saveAuth(UsersAuth usersAuth) {
        return this.usersAuthRepository.save(usersAuth);
    }
}
