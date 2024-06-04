package com.example.testtaskforcomparusua.service;

import com.example.testtaskforcomparusua.entity.User;
import com.example.testtaskforcomparusua.firstDB.repository.UserFirstDBRepository;
import com.example.testtaskforcomparusua.secondDB.repository.UserSecondDBRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class ClientMasterService {

    private final UserFirstDBRepository userFirstDBRepository;
    private final UserSecondDBRepository userSecondDBRepository;

    public List<User> getClientNames() {
        return Stream.concat(userFirstDBRepository.findAll().stream(),
                        userSecondDBRepository.findAll().stream())
                .toList();
    }
}
