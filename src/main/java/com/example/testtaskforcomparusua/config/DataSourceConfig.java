package com.example.testtaskforcomparusua.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

