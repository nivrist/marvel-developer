package com.marvel.developer.config.jndi;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "niloEntityManagerFactory", transactionManagerRef = "niloTransactionManager", basePackages = {
		"com.siman.nilo.rubik.wa.repository" })
public class NiloJndiDataSourceConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "app.datasource.nilo")
	public JndiPropertyHolder niloJndiProperties() {
		return new JndiPropertyHolder();
	}

	@Bean(name = "niloDataSource", destroyMethod = "")
	@Primary
	public DataSource niloJndiDataSource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		DataSource dataSource = dataSourceLookup.getDataSource(niloJndiProperties().getJndiName());
		return dataSource;
	}

	@Primary
	@Bean(name = "niloEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("niloDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.siman.nilo.rubik.wa.model.nilotfn").persistenceUnit("niloRubikPU")
				.build();
	}

	@Primary
	@Bean(name = "niloTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("niloEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
