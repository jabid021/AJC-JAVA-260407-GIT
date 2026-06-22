package fr.formation.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import fr.formation.repo.UtilisateurRepository;

@Configuration
@EnableMethodSecurity(prePostEnabled = true) // Activer les annotations @PreAuthorize & @PostAuthorize
public class SecurityConfig {

    // ---- AUTHORIZATION -----

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthHeaderFilter authHeaderFilter) throws Exception {
        // Configuration des autorisations
        http.authorizeHttpRequests(auth -> {
            // On commence toujours par le plus spécifique, pour terminer par le plus général
            // auth.requestMatchers("/api/produit/**").hasRole("ADMIN");
            // auth.requestMatchers("/utilisateur/**").hasRole("USER");

            auth.requestMatchers("/api/auth").permitAll();

            // Les utilisateurs doivent être authentifiés pour accéder à /quelquechose
            auth.requestMatchers("/**").authenticated();
        });

        // Réactiver la connexion par formulaire de login
        http.formLogin(Customizer.withDefaults());

        // Réactiver la connexion par HTTP Basic
        http.httpBasic(Customizer.withDefaults());

        // Insérer le filtre AVANT un filtre UsernamePasswordAuthenticationFilter
        // http.addFilterBefore(demoFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(authHeaderFilter, UsernamePasswordAuthenticationFilter.class);

        // Désactivation de la protection CSRF uniquement pour les ressources /api/**
        http.csrf(csrf -> csrf.ignoringRequestMatchers("/api/**"));

        return http.build();
    }



    // ---- AUTHENTIFICATION ----

    // @Bean
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

    // @Bean
    UserDetailsService jpaDetailsService(UtilisateurRepository repository) {
        return username -> {
            return repository
                .findByUsername(username)
                .map(utilisateur -> User.builder()
                    .username(username)
                    .password(utilisateur.getPassword())
                    .roles(utilisateur.isAdmin() ? "ADMIN" : "USER")
                    .build()
                )
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"))
            ;
        };
    }


    // @Bean
    UserDetailsService jpaDetailsService2(UtilisateurRepository repository) {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return repository
                    .findByUsername(username)
                    .map(utilisateur -> User.builder()
                        .username(username)
                        .password(utilisateur.getPassword())
                        .roles(utilisateur.isAdmin() ? "ADMIN" : "USER")
                        .build()
                    )
                    .orElseThrow(() -> new UsernameNotFoundException("Username not found"))
                ;
            }
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        System.out.println(passwordEncoder.encode("123456"));

        return passwordEncoder;
    }
}
