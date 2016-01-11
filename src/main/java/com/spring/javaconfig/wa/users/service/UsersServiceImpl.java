package com.spring.javaconfig.wa.users.service;

import com.spring.javaconfig.wa.users.dao.UsersDao;
import com.spring.javaconfig.wa.users.entity.Users;
import com.spring.javaconfig.wa.users.entity.UsersAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.PostLoad;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bangae1 on 2016-01-11.
 */
@Service
public class UsersServiceImpl implements UserDetailsService, UsersService {
    @Autowired
    private UsersDao usersDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersDao.loadUserByUsername(username);
        Set<UsersAuth> set = user.getUsersAuths();
        HashSet<GrantedAuthority> hashSet = new HashSet<GrantedAuthority>();
        for(UsersAuth auth : set) {
            final String authority = auth.getAuthority();
            hashSet.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return authority;
                }
            });
        }
        user.setAuthorities(hashSet);
        return user;
    }

    @Override
    public Users findEmail(String email) {
        return null;
    }
}
