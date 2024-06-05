package com.example.testtaskforcomparusua.service;


import com.example.testtaskforcomparusua.config.DataSourceConfig;
import com.example.testtaskforcomparusua.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Configuration
//@ConfigurationProperties(prefix = "data-sources")
public class UserService {

    private DataSourceConfig dataSourceConfig;

    @PostConstruct
    private void loadConfig() {
        Yaml yaml = new Yaml();
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("application.yml")) {
            dataSourceConfig = yaml.loadAs(in, DataSourceConfig.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration", e);
        }
    }

    public List<User> getUsers() throws Exception {
        List<User> allUsers = new ArrayList<>();

        for (DataSourceConfig.DataSource source : dataSourceConfig.getDataSources()) {
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection connection = DriverManager.getConnection(source.getUrl(), source.getUser(), source.getPassword());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + source.getTable());

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString(source.getMapping().get("id")));
                user.setUsername(resultSet.getString(source.getMapping().get("username")));
                user.setName(resultSet.getString(source.getMapping().get("name")));
                user.setSurname(resultSet.getString(source.getMapping().get("surname")));
                allUsers.add(user);
            }

            resultSet.close();
            statement.close();
            connection.close();
        }

        return allUsers;
    }
}

