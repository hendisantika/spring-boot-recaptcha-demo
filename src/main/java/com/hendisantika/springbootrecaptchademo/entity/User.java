package com.hendisantika.springbootrecaptchademo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-recaptcha-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 05/12/17
 * Time: 06.35
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(max = 50)
    private String firstName;

    @NotEmpty @Size(max = 50)
    private String lastName;

    @NotEmpty @Size(max = 128)
    private String email;

    @NotEmpty @Size(max = 60)
    @JsonIgnore
    private String password;

    @Transient
    @JsonIgnore
    private String confirmPassword;
}
