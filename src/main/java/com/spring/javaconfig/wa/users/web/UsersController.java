package com.spring.javaconfig.wa.users.web;

import com.spring.javaconfig.wa.users.entity.Users;
import com.spring.javaconfig.wa.users.repository.UsersRepository;
import com.spring.javaconfig.wa.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bangae1 on 2016-01-11.
 */
@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/save")
    public String saveJoin(@ModelAttribute("users")Users user, Model model) {
        System.out.println(user.getName() + "##########################");
        this.usersService.save(user);
        return "redirect:/";
    }
}
