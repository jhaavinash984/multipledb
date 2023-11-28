package com.cisco.renewalsatrload.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;


@Configuration
@EnableJpaRepositories(
    basePackages = "com.cisco.renewalsatrload.repository.primarydb", 
    entityManagerFactoryRef = "primaryEntityManager", 
    transactionManagerRef = "primaryTransactionManager"
)
@EnableTransactionManagement
public class PrimaryDBConfiguration {
	
	@Autowired
    private Environment env;
    
    @Bean(name="primaryEntityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean primarytEntityManager(EntityManagerFactoryBuilder builder,
            @Qualifier("primaryDataSource") DataSource dataSource) {
		/*
		 * LocalContainerEntityManagerFactoryBean em = new
		 * LocalContainerEntityManagerFactoryBean();
		 * em.setDataSource(primaryDataSource()); em.setPackagesToScan( new String[] {
		 * "com.cisco.renewalsatrload.entity.primarydb" });
		 * 
		 * HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		 * em.setJpaVendorAdapter(vendorAdapter); HashMap<String, Object> properties =
		 * new HashMap<>(); properties.put("hibernate.hbm2ddl.auto",
		 * env.getProperty("spring.datasource.hibernate.hbm2ddl.auto"));
		 * properties.put("hibernate.dialect",
		 * env.getProperty("spring.datasource.hibernate.dialect"));
		 * em.setJpaPropertyMap(properties);
		 * 
		 * return em;
		 */
    	return builder
                .dataSource(dataSource)
                .packages("com.cisco.renewalsatrload.entity.primarydb")
                .persistenceUnit("primary")
                .build();
    }

    @Primary
    @Bean(name="primaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource primaryDataSource() {
 
		/*
		 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
		 * dataSource.setDriverClassName(
		 * env.getProperty("spring.datasource.driverClassName"));
		 * dataSource.setUrl(env.getProperty("spring.datasource.jdbcUrl"));
		 * dataSource.setUsername(env.getProperty("spring.datasource.username"));
		 * dataSource.setPassword(env.getProperty("spring.datasource.password")); return
		 * dataSource;
		 */
    	return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name="primaryTransactionManager")
    public PlatformTransactionManager primaryTransactionManager(@Qualifier("primaryEntityManager") EntityManagerFactory
            primaryEntityManager) {
 
		/*
		 * JpaTransactionManager transactionManager = new JpaTransactionManager();
		 * transactionManager.setEntityManagerFactory(
		 * primarytEntityManager().getObject()); return transactionManager;
		 */
    	return new JpaTransactionManager(primaryEntityManager);
    }

}
