package fr.formation.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import fr.formation.model.Utilisateur;
import fr.formation.repo.UtilisateurRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthHeaderFilter extends OncePerRequestFilter {
    @Autowired
    private UtilisateurRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null) {
            System.out.println("Header = " + authHeader);
            // String username = authHeader.replace("Bearer ", "");
            String username = authHeader.substring(7);

            System.out.println("Username = " + username);

            Optional<Utilisateur> optUtilisateur = this.repository.findByUsername(username);

            if (optUtilisateur.isPresent()) {
                List<GrantedAuthority> authorities = new ArrayList<>();

                if (optUtilisateur.get().isAdmin()) {
                    authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                }

                else {
                    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                }

                Authentication auth = new UsernamePasswordAuthenticationToken(username, null, authorities);

                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        // On pense à passer à la suite
        filterChain.doFilter(request, response);
    }
}
