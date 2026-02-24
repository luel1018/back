package org.example.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.web.authentication.AuthenticationFilter;

@SpringBootApplication
public class BackApplication {

    public static void main(String[] args) {

        SpringApplication.run(BackApplication.class, args);
    }

}