package com.example.imersive.service;

import com.example.imersive.models.User;
import com.example.imersive.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    // Salvar usuario
    public User save(User user) {
        return repository.save(user);
    }

    // Buscar usuario por ID
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    // Listar todos os usuarios
    public List<User> findAll() {
        return repository.findAll();
    }

    // Deletar usuario por ID
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
