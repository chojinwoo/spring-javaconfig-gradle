package com.spring.javaconfig.wa.users.web;

import com.spring.javaconfig.wa.users.repository.UsersRepository;
import com.spring.javaconfig.wa.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bangae1 on 2016-01-11.
 */
@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/")
    public String index() {
        return "login";
    }
}
