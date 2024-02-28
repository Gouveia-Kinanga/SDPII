package edu.ucan.Transacaoancaria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfiguracaoSeguranca
{
    @Bean
    CorsConfigurationSource habilitarCORS()
    {
        CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowedOrigins(List.of("*"));
        cors.setAllowedMethods(Arrays.asList("*", "GET", "POST", "DELETE", "PUT", "PATCH", "HEAD"));
        cors.setAllowedHeaders(List.of("*"));
        cors.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource baseCors = new UrlBasedCorsConfigurationSource();
        baseCors.registerCorsConfiguration("/**", cors);
        return baseCors;
    }
    
    @Bean
    public org.springframework.security.web.SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests().anyRequest()
                .permitAll()
                .and()
                .cors()
                .configurationSource(this.habilitarCORS());
        return http.build();
    }
    
}

