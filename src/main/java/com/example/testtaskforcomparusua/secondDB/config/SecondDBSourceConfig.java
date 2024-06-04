package com.example.testtaskforcomparusua.secondDB.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "userEntityManagerFactory",
		transactionManagerRef = "userTransactionManager",
		basePackages = { "com.example.testtaskforcomparusua.secondDB.repository" }
)
public class SecondDBSourceConfig {
	@Bean(name="secondDbDataSource")
	@ConfigurationProperties(prefix="spring.second-db.datasource")
	public DataSource userDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "secondDbEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(EntityManagerFactoryBuilder builder,
																		   @Qualifier("secondDbDataSource") DataSource userDataSource) {
		return builder
				.dataSource(userDataSource)
				.packages("com.example.testtaskforcomparusua.entity")
				.build();
	}

	@Bean(name = "secondDbTransactionManager")
	public PlatformTransactionManager userTransactionManager(
			@Qualifier("secondDbEntityManagerFactory") EntityManagerFactory userEntityManagerFactory) {
		return new JpaTransactionManager(userEntityManagerFactory);
	}

}
