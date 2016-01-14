package com.spring.javaconfig.wa.main.web;

import com.spring.javaconfig.wa.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by bangae1 on 2016-01-11.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping("/join")
    public String join() {
        return "join";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }
}
