package com.example.ugchaus.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class FirebaseConfig {

    @Bean
    public FirebaseApp getFirebaseApp(Environment environment) throws IOException {
        FileInputStream firebaseAccount = new FileInputStream(Objects.requireNonNull(environment.getProperty("app.firebase.cred")));
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(firebaseAccount))
                .build();
        return FirebaseApp.initializeApp(options);
    }

}
