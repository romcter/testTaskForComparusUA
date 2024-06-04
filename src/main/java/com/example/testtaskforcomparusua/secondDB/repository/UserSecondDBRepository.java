package com.example.testtaskforcomparusua.secondDB.repository;

import com.example.testtaskforcomparusua.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserSecondDBRepository extends JpaRepository<User, Long>{

}
