package com.example.testtaskforcomparusua.rest;

import com.example.testtaskforcomparusua.entity.User;
import com.example.testtaskforcomparusua.service.ClientMasterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientDataController {

    private ClientMasterService clientMasterService;

    @GetMapping
    public List<User> findFromDatabase() {
        return clientMasterService.getClientNames();
    }
}
