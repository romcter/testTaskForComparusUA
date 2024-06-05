package com.example.testtaskforcomparusua.rest;

import com.example.testtaskforcomparusua.entity.User;
import com.example.testtaskforcomparusua.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class ClientDataController {

    private UserService userService;

    @GetMapping
    public List<User> findFromDatabase() throws Exception {
        return userService.getUsers();
    }
}
