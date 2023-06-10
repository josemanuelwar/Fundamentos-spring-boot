package com.fundamentosplatzi.springboot.fundamento.service;

import com.fundamentosplatzi.springboot.fundamento.entity.Usuario;
import com.fundamentosplatzi.springboot.fundamento.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public void saveTransactional(List<Usuario> users){
        users.stream()
                .peek(user -> LOG.info("Usuario insertado "+user))
                .forEach(userRepository::save);
    }

    public List<Usuario> getAllUsers(){
        return userRepository.findAll();
    }


    public Usuario save(Usuario newUdusrio) {
        return  this.userRepository.save(newUdusrio);
    }

    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }

    public Usuario update(Usuario newUdusrio, Long id) {
        return this.userRepository.findById(id)
                .map(
                user -> {
                    user.setEmail(newUdusrio.getEmail());
                    user.setName(newUdusrio.getName());
                    user.setBirthDate(newUdusrio.getBirthDate());
                    return userRepository.save(user);
                }).get();
    }
}
