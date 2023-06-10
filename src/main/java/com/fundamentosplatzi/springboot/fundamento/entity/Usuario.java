package com.fundamentosplatzi.springboot.fundamento.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario",nullable = false,unique = true)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 100, unique = true)
    private String email;
    private LocalDate birthDate;
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Post> postList= new ArrayList<>();

    public Usuario(){

    }

    public Usuario(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Usuario(String name, String email, LocalDate birthDate, List<Post> postList) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.postList = postList;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", postList=" + postList +
                '}';
    }
}
