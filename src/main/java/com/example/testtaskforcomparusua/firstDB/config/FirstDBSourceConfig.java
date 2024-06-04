package com.example.testtaskforcomparusua.firstDB.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "accountEntityManagerFactory",
  transactionManagerRef = "accountTransactionManager",
		basePackages = { "com.example.testtaskforcomparusua.firstDB.repository" }
)
public class FirstDBSourceConfig {
	
	@Bean(name="firstDbDataSource")
	@Primary
	@ConfigurationProperties(prefix="spring.first-db.datasource")
	public DataSource accountDataSource() {
	    return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "firstDbEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean accountEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("firstDbDataSource") DataSource accountDataSource) {
		return builder
				.dataSource(accountDataSource)
				.packages("com.example.testtaskforcomparusua.entity")
				.build();
	}
	
	@Bean(name = "accountTransactionManager")
	public PlatformTransactionManager accountTransactionManager(
			@Qualifier("firstDbEntityManagerFactory") EntityManagerFactory accountEntityManagerFactory) {
		return new JpaTransactionManager(accountEntityManagerFactory);
	}

}
