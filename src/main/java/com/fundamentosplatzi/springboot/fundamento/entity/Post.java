package com.fundamentosplatzi.springboot.fundamento.entity;


import jakarta.persistence.*;

@Entity
@Table(name="post")
public class Post {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_post",nullable = false,unique = true)
    private Long id;
   @Column(name="descripcion",length = 255)
    private String description;
   @ManyToOne
   private Usuario usuario;

   public Post(){

   }

    public Post(Long id, String description, Usuario usuario) {
        this.id = id;
        this.description = description;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
