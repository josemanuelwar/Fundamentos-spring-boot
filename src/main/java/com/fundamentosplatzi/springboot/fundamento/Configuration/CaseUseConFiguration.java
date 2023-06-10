package com.fundamentosplatzi.springboot.fundamento.Configuration;

import com.fundamentosplatzi.springboot.fundamento.caseUse.GetUser;
import com.fundamentosplatzi.springboot.fundamento.caseUse.GetUserImplement;
import com.fundamentosplatzi.springboot.fundamento.entity.Usuario;
import com.fundamentosplatzi.springboot.fundamento.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CaseUseConFiguration {
    @Bean
    GetUser getUser(UserService userService){
       return new GetUserImplement(userService);
    }
}
