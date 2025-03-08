package com.example.imersive.repositories;

import com.example.imersive.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Métodos personalizados podem ser adicionados aqui
}