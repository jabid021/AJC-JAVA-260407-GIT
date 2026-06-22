package fr.formation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.formation.repo.UtilisateurRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    private UtilisateurRepository repository;

    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     Utilisateur utilisateur = this.repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));

    //     return User.builder()
    //         .username(username)
    //         .password(utilisateur.getPassword())
    //         .roles(utilisateur.isAdmin() ? "ADMIN" : "USER")
    //         .build()
    //     ;
    // }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repository
            .findByUsername(username)
            .map(utilisateur -> User.builder()
                .username(username)
                .password(utilisateur.getPassword())
                // .roles(utilisateur.isAdmin() ? "ADMIN" : "USER")
                // roles("ADMIN") et authorities("ROLE_ADMIN") => exactement la même chose
                .authorities("PRODUCT_READ", "ROLE_ADMIN")
                .build()
            )
            .orElseThrow(() -> new UsernameNotFoundException("Username not found"))
        ;
    }

}
