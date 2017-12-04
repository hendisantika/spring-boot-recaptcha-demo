package com.hendisantika.springbootrecaptchademo.controller;

import com.hendisantika.springbootrecaptchademo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-recaptcha-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 05/12/17
 * Time: 06.41
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class ViewController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }
}
