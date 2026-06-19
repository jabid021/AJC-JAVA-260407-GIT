package fr.formation.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
            .password("{noop}123456")
            .roles("ADMIN")
            .build()
        ;

        // On ajoute "admin" à la liste des users
        inMemoryManager.createUser(admin);

        return inMemoryManager;
    }
}
