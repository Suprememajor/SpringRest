package com.supremecorp.springrest.configuration;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Value("${spring.datasource.url}")
    private String databaseUrl;
    @Value("${spring.datasource.hikari.connection-timeout}")
    private long connTimeout;
    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private int maxPoolSize;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Bean
    public HikariConfig hikariConfig() {
        String[] dbInfo = databaseUrl.split("@");
        String[] credentials = dbInfo[0].split("[/:]+");
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://" + dbInfo[1]);
        hikariConfig.setUsername(credentials[1]);
        hikariConfig.setPassword(credentials[2]);
        hikariConfig.setConnectionTimeout(connTimeout);
        hikariConfig.setMaximumPoolSize(maxPoolSize);
        hikariConfig.setDriverClassName(driverClassName);
        return hikariConfig;
    }
}
