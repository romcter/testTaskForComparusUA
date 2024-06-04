package com.example.testtaskforcomparusua.service;

import com.example.testtaskforcomparusua.config.ClientNames;
import com.example.testtaskforcomparusua.config.DBContextHolder;
import com.example.testtaskforcomparusua.entity.User;
import com.example.testtaskforcomparusua.repository.ClientMasterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientMasterService {

    private ClientMasterRepository clientMasterRepository;

    public String getClientNames(String client) {
        switch (client) {
            case "db1" -> DBContextHolder.setCurrentDb(ClientNames.DB1);
            case "db2" -> DBContextHolder.setCurrentDb(ClientNames.DB2);
            case "db3" -> DBContextHolder.setCurrentDb(ClientNames.DB3);
        }
        User e1 = clientMasterRepository.findByEntity1Name("John Doe");
        if(e1 != null) {
            return "found in database: " + client + " with id " + e1.getId();
        }
        return "found in " + client + " nada!";
    }
}
