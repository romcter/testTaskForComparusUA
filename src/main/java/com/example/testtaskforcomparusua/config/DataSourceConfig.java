package com.example.testtaskforcomparusua.config;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DataSourceConfig {
    private List<DataSource> dataSources;

    @Data
    public static class DataSource {
        private String name;
        private String strategy;
        private String url;
        private String user;
        private String password;
        private String table;
        private Map<String, String> mapping;
    }
}

