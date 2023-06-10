package com.fundamentosplatzi.springboot.fundamento.caseUse;

import com.fundamentosplatzi.springboot.fundamento.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {

    private UserService userService;

    public DeleteUser(UserService userService){
        this.userService=userService;
    }

    public void remove(Long id) {
        this.userService.delete(id);
    }
}
