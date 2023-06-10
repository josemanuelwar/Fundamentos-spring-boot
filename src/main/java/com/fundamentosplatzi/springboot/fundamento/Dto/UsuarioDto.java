package com.fundamentosplatzi.springboot.fundamento.Dto;

import java.time.LocalDate;

public class UsuarioDto {
    private Long id;
    private String name;
    private LocalDate brithDate;

    public UsuarioDto(Long id, String name, LocalDate brithDate) {
        this.id = id;
        this.name = name;
        this.brithDate = brithDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setNameçç(String name) {
        this.name = name;
    }

    public LocalDate getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(LocalDate brithDate) {
        this.brithDate = brithDate;
    }

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brithDate='" + brithDate + '\'' +
                '}';
    }
}
