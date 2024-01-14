package com.example.projectppro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProjectPproApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectPproApplication.class, args);
    }

}
