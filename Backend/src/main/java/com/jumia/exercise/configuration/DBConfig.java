package com.jumia.exercise.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DBConfig {
    @Autowired
    Environment environment;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(environment.getProperty("spring.jpa.datasource.driver-class-name"));
        dataSourceBuilder.url(environment.getProperty("spring.jpa.datasource.url"));
        return dataSourceBuilder.build();
    }
}
