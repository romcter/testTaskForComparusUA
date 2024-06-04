package com.example.testtaskforcomparusua.rest;

import com.example.testtaskforcomparusua.service.ClientMasterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientDataController {

    private ClientMasterService clientMasterService;

    @GetMapping("/{clientdb}")
    public String findFromDatabase(@PathVariable String clientdb) {
        return clientMasterService.getClientNames(clientdb);
    }
}
