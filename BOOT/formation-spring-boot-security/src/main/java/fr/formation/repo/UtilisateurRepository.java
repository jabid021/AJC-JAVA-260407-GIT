package fr.formation.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    public Optional<Utilisateur> findByUsername(String username);
}
