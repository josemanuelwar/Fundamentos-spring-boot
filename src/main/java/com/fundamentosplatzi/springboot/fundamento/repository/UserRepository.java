package com.fundamentosplatzi.springboot.fundamento.repository;

import com.fundamentosplatzi.springboot.fundamento.entity.Usuario;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario,Long> {

    @Query("Select u from Usuario u where u.email=?1")
    Optional<Usuario> findByUserEmail(String email);
    @Query("SELECT u from Usuario u where u.name like ?1%")
    List<Usuario> findAndShort(String name, Sort sort);

    List<Usuario> findByName(String name);
    Optional<Usuario> findByEmailAndName(String email,String name);


}
