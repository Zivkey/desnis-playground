package com.example.ugchaus.config;

import com.example.ugchaus.util.constants.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;


//@Configuration
//@EnableWebSecurity
public class SecurityConfig {


//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable);
//        http.cors(withDefaults());
//        http.authorizeHttpRequests((auth) -> auth
//                .requestMatchers(Constants.API_DOCS, Constants.API_DOCS_ONLY,
//                        Constants.SWAGGER_UI, Constants.RESOURCES).permitAll()
//                .requestMatchers(new RegexRequestMatcher(".*public.*", null)).permitAll()
//                .anyRequest().authenticated());
//        http.oauth2ResourceServer(auth -> auth.jwt(withDefaults()));
//        return http.build();
//    }
//
//
//    @Bean
//    public WebMvcConfigurer corsMappingConfigure() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedHeaders("Access-Control-Allow-Origin",
//                                "*",
//                                "Access-Control-Allow-Methods",
//                                "POST, GET, OPTIONS, PUT, DELETE",
//                                "Access-Control-Allow-Headers",
//                                "Origin, X-Requested-With, Content-Type, Accept")
//                        .allowedOrigins("*")
//                        .allowedMethods("*");
//            }
//        };
//    }

}
