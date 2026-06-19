package fr.formation.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    UserDetailsService inMemoryUserDetailsService() {
        // Le UserDetailsService permet de charger l'utilisateur, son mot de passe, ses autorisations, etc.
        InMemoryUserDetailsManager inMemoryManager = new InMemoryUserDetailsManager();

        // Configurer sa liste d'utilisateurs

        // Le UserDetails, c'est un "user" retourné par le UserDetailsService, qui sera utilisé par Spring Security
        UserDetails admin = User.builder()
            .username("admin")
            // NoOp => NoOperator => mot de passe en clair
            // .password("{noop}123456")
            // .password("$2a$10$GtV86i/hD/2PHFXP4jp.I.rqbbTMAf.n/6DzsKAv/f1/LeqctsAk2")
            .password("$2a$10$KoYSgHh3vNKhYWE9AQRM6e2GwKa92xu3nsM4/vcnLjQlmti5IGE1y")
            .roles("ADMIN")
            .build()
        ;

        // On ajoute "admin" à la liste des users
        inMemoryManager.createUser(admin);

        return inMemoryManager;
    }

    @Bean
    PasswordEncoder PasswordEncoder() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        System.out.println(passwordEncoder.encode("123456"));

        return passwordEncoder;
    }
}
