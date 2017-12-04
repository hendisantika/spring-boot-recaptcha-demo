package com.hendisantika.springbootrecaptchademo.controller;

import com.hendisantika.springbootrecaptchademo.entity.User;
import com.hendisantika.springbootrecaptchademo.repository.UserRepository;
import com.hendisantika.springbootrecaptchademo.service.RecaptchaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-recaptcha-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 05/12/17
 * Time: 06.43
 * To change this template use File | Settings | File Templates.
 */

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RecaptchaService captchaService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid User user,
                                    @RequestParam(name="g-recaptcha-response") String recaptchaResponse,
                                    HttpServletRequest request){

        String ip = request.getRemoteAddr();
        String captchaVerifyMessage =
                captchaService.verifyRecaptcha(ip, recaptchaResponse);

        if ( StringUtils.isNotEmpty(captchaVerifyMessage)) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", captchaVerifyMessage);
            return ResponseEntity.badRequest()
                    .body(response);
        }

        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> users(){
        return ResponseEntity.ok(userRepository.findAll());
    }
}
