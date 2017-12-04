package com.hendisantika.springbootrecaptchademo.repository;

import com.hendisantika.springbootrecaptchademo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-recaptcha-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 05/12/17
 * Time: 06.36
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends JpaRepository<User, Long>{
}
