package com.fundamentosplatzi.springboot.fundamento.caseUse;

import com.fundamentosplatzi.springboot.fundamento.entity.Usuario;
import com.fundamentosplatzi.springboot.fundamento.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{

    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<Usuario> getAll() {
        return this.userService.getAllUsers();
    }
}
