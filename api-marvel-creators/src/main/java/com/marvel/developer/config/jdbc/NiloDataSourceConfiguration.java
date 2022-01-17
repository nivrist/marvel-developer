package com.marvel.developer.config.jdbc;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "marvelEntityManagerFactory", transactionManagerRef = "marvelTransactionManager", basePackages = {
		"com.marvel.developer.repository" })
public class NiloDataSourceConfiguration {

	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.marveldb")
	public DataSourceProperties niloDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "marvelDataSource")
	@Primary
	@ConfigurationProperties("app.datasource.marveldb.configuration")
	public DataSource niloDataSource() {
		return niloDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Primary
	@Bean(name = "marvelEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("marvelDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.marvel.developer.model").persistenceUnit("marvelAppPU")
				.build();
	}

	@Primary
	@Bean(name = "marvelTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("marvelEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
