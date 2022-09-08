package com.supremecorp.springrest;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
// @SpringBootApplication is a meta-annotation that pulls in component scanning, autoconfiguration, and property support.
@RequiredArgsConstructor
public class SpringRestApplication {
    private final HikariConfig hikariConfig;


    public static void main(String[] args) {
        SpringApplication.run(SpringRestApplication.class, args);
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig);
    }
}
