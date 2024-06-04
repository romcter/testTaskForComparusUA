package com.example.testtaskforcomparusua.repository;

import com.example.testtaskforcomparusua.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientMasterRepository extends JpaRepository<User, String> {
    User findByEntity1Name(String name);
}
