package fr.formation.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
// OncePerRequestFilter -> garantir que ce filtre ne sera exécuter qu'une seule fois
public class DemoFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("JE SUIS PASSE DANS LE FILTRE");

        String header = request.getHeader("Authorization");

        System.out.println("Affichage header = " + header);

        // Création de la liste des autorisations
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        // Pour créer une authentification à la mano, utiliser la classe UsernamePasswordAuthenticationToken
        Authentication auth = new UsernamePasswordAuthenticationToken("LeUser", null, authorities);

        // On va donner cette authentification au contexte de sécurité
        SecurityContextHolder.getContext().setAuthentication(auth);

        // Sans cette instruction, on ne passe pas au filtre suivant
        filterChain.doFilter(request, response);
    }
}
