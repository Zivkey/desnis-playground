package com.example.ugchaus;

import com.example.ugchaus.entity.User;
import com.example.ugchaus.enums.UserRoleEnum;
import com.example.ugchaus.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class Main {

    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);



    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
        };
    }

}
