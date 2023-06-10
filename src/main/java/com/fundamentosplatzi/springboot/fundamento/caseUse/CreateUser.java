package com.fundamentosplatzi.springboot.fundamento.caseUse;

import com.fundamentosplatzi.springboot.fundamento.entity.Usuario;
import com.fundamentosplatzi.springboot.fundamento.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService){
        this.userService=userService;
    }

    public Usuario save(Usuario newUdusrio) {
        return this.userService.save(newUdusrio);
    }
}
