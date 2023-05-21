package com.fundamentosplatzi.springboot.fundamento.bean;

public class MyBeanImplemetUser implements User{

    private String nombre;
    private String apellido;

    public MyBeanImplemetUser(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public void impirmir() {
        System.out.println("Nombre de usuario: "
                .concat(this.nombre)
                .concat(" Apellido: "
                        .concat(this.apellido)));
    }
}
