package com.example.testtaskforcomparusua.firstDB.repository;

import com.example.testtaskforcomparusua.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFirstDBRepository extends JpaRepository<User, Long>{

}
