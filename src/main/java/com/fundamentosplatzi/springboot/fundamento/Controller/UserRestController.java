package com.fundamentosplatzi.springboot.fundamento.Controller;

import com.fundamentosplatzi.springboot.fundamento.caseUse.CreateUser;
import com.fundamentosplatzi.springboot.fundamento.caseUse.DeleteUser;
import com.fundamentosplatzi.springboot.fundamento.caseUse.GetUser;
import com.fundamentosplatzi.springboot.fundamento.caseUse.UpdateUser;
import com.fundamentosplatzi.springboot.fundamento.entity.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    //create get delete update

    private GetUser getUser;
    private CreateUser createUser;

    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    public UserRestController(GetUser getUser, CreateUser createUser,
                              DeleteUser deleteUser,UpdateUser updateUser) {
        this.getUser = getUser;
        this.createUser=createUser;
        this.deleteUser=deleteUser;
        this.updateUser=updateUser;
    }
    @GetMapping("/")
    public  List<Usuario> get(){
        return getUser.getAll();
    }
    @PostMapping("/")
    public ResponseEntity<Usuario> newUser(@RequestBody Usuario newUdusrio){
        return new ResponseEntity<>(this.createUser.save(newUdusrio), HttpStatus.CREATED);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
       this.deleteUser.remove(id);
       return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> replaceUser(@RequestBody Usuario newUdusrio,
                                               @PathVariable Long id){
        return new ResponseEntity (this.updateUser.update(newUdusrio,id),HttpStatus.OK);

    }

}
