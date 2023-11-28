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
    basePackages = "com.cisco.renewalsatrload.repository.secondarydb", 
    entityManagerFactoryRef = "secondaryEntityManager", 
    transactionManagerRef = "secondaryTransactionManager"
)
@EnableTransactionManagement
public class SecondaryDBConfiguration {
	
	@Autowired
    private Environment env;
    
    @Bean(name="secondaryEntityManager")
    public LocalContainerEntityManagerFactoryBean secondaryEntityManager(EntityManagerFactoryBuilder builder,
            @Qualifier("secondaryDataSource") DataSource dataSource) {
		/*
		 * LocalContainerEntityManagerFactoryBean em = new
		 * LocalContainerEntityManagerFactoryBean();
		 * em.setDataSource(secondaryDataSource()); em.setPackagesToScan( new String[] {
		 * "com.cisco.renewalsatrload.entity.secondarydb" });
		 * 
		 * HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		 * em.setJpaVendorAdapter(vendorAdapter); HashMap<String, Object> properties =
		 * new HashMap<>(); properties.put("hibernate.hbm2ddl.auto",
		 * env.getProperty("spring.second-datasource.hibernate.hbm2ddl.auto"));
		 * properties.put("hibernate.dialect",
		 * env.getProperty("spring.second-datasource.hibernate.dialect"));
		 * em.setJpaPropertyMap(properties);
		 * 
		 * return em;
		 */
    	return builder
                .dataSource(dataSource)
                .packages("com.cisco.renewalsatrload.entity.secondarydb")
                .persistenceUnit("secondary")
                .build();
    }


    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix="spring.second-datasource")
    public DataSource secondaryDataSource() {
 
		/*
		 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
		 * dataSource.setDriverClassName(
		 * env.getProperty("spring.second-datasource.driverClassName"));
		 * dataSource.setUrl(env.getProperty("spring.second-datasource.jdbcUrl"));
		 * dataSource.setUsername(env.getProperty("spring.second-datasource.username"));
		 * dataSource.setPassword(env.getProperty("spring.second-datasource.password"));
		 * return dataSource;
		 */
    	return DataSourceBuilder.create().build();
    }

 
    @Bean(name="secondaryTransactionManager")
    public PlatformTransactionManager secondaryTransactionManager(@Qualifier("secondaryEntityManager") EntityManagerFactory
            secondaryEntityManager) {
 
		/*
		 * JpaTransactionManager transactionManager = new JpaTransactionManager();
		 * transactionManager.setEntityManagerFactory(
		 * secondaryEntityManager().getObject()); return transactionManager;
		 */
    	return new JpaTransactionManager(secondaryEntityManager);
    }

}
