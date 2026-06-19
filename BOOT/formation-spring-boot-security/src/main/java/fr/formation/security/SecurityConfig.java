package fr.formation.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // ---- AUTHORIZATION -----

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Configuration des autorisations
        http.authorizeHttpRequests(auth -> {
            // On commence toujours par le plus spécifique, pour terminer par le plus général
            auth.requestMatchers("/produit/**").hasRole("ADMIN");
            auth.requestMatchers("/utilisateur/**").hasRole("USER");

            // auth.requestMatchers("/demo").permitAll();

            // Les utilisateurs doivent être authentifiés pour accéder à /quelquechose
            auth.requestMatchers("/**").authenticated();
        });

        // Réactiver la connexion par formulaire de login
        http.formLogin(Customizer.withDefaults());

        // Réactiver la connexion par HTTP Basic
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }



    // ---- AUTHENTIFICATION ----

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
    PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        System.out.println(passwordEncoder.encode("123456"));

        return passwordEncoder;
    }
}
