package com.example.h2dbcrudexample.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilderCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
//@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
//                        basePackages = {"com.example.h2dbcrudexample"})
//@EnableTransactionManagement
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DbConfig {

//    @Autowired
//    Environment env;

    @Primary
    @Bean
    public DataSource getDataSource(){
        return DataSourceBuilder.create()
                .driverClassName(dbProperties().getDriverClassName())
                .url(dbProperties().getUrl())
                .username(dbProperties().getUrl())
                .password(dbProperties().getPassword()).build();
    }

    @Bean("dbProperties")
    @ConfigurationProperties(prefix = "crud.db")
    public DBProperties dbProperties() {
        return new DBProperties();
    }

    @Bean
    @ConfigurationProperties("crud.db")
    public HikariDataSource dataSource(DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class)
                .build();
    }

//    @Primary
//    @Bean("entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
//                                                                       @Qualifier("dataSource") DataSource dataSource) {
//
//        Map<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto",
//                env.getProperty("spring.jpa.hibernate.ddl-auto"));
//        properties.put("hibernate.dialect",
//                env.getProperty("spring.jpa.properties.hibernate.dialect"));
//        LocalContainerEntityManagerFactoryBean bean =
//                builder.dataSource(dataSource)
//                                .packages("com.example.h2dbcrudexample").
//                        persistenceUnit("primaryPersistenceUnit")
//                        .build();
////        bean.setPersistenceUnitPostProcessors(pui -> pui.addManagedClassName());
//
//        return bean;
//    }
//
//    @Primary
//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory")EntityManagerFactory entityManagerFactory) {
//        return  new JpaTransactionManager(entityManagerFactory);
//    }

//    @Bean
//    public EntityManagerFactoryBuilder entityManagerFactoryBuilder(JpaVendorAdapter jpaVendorAdapter,
//                                                                   ObjectProvider<PersistenceUnitManager> persistenceUnitManagers,
//                                                                   ObjectProvider<EntityManagerFactoryBuilderCustomizer> customizers){
//        EntityManagerFactoryBuilder builder = new EntityManagerFactoryBuilder(jpaVendorAdapter, this.)
//        return builder;
//    }
}
