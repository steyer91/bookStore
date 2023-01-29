package springmongoapp.bookStore.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration
{
    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests().anyRequest().authenticated();
        http.formLogin();
        http.httpBasic();

        return http.build();
    }
}
