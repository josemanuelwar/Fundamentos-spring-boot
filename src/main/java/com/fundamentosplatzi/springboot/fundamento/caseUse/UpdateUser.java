package com.fundamentosplatzi.springboot.fundamento.caseUse;

import com.fundamentosplatzi.springboot.fundamento.entity.Usuario;
import com.fundamentosplatzi.springboot.fundamento.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {

    private UserService userService;

    public UpdateUser( UserService userService){
        this.userService=userService;
    }

    public Usuario update(Usuario newUdusrio, Long id) {
        return this.userService.update(newUdusrio,id);
    }
}
