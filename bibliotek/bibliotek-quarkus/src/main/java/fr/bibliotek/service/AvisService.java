package fr.bibliotek.service;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.bibliotek.api.request.CreateOrUpdateAvisRequest;
import fr.bibliotek.exception.AvisNotFoundException;
import fr.bibliotek.model.Avis;
import fr.bibliotek.repo.AvisRepository;
import fr.bibliotek.repo.LivreRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AvisService {
    private static final Logger log = LoggerFactory.getLogger(AvisService.class);
    private final AvisRepository repository;
    private final LivreRepository livreRepository;

    public AvisService(AvisRepository repository, LivreRepository livreRepository) {
        this.repository = repository;
        this.livreRepository = livreRepository;
    }

    public Stream<Avis> findAll() {
        log.debug("Liste des avis ...");

        return this.repository.findAll().stream();
    }

    public Avis findById(String id) {
        log.debug("Recherche de l'avis {} ...", id);

        return this.repository.findByIdOptional(id).orElseThrow(AvisNotFoundException::new);
    }

    @Transactional
    public Avis save(CreateOrUpdateAvisRequest request) {
        log.debug("Création d'un avis ...");

        Avis avis = this.save(new Avis(), request);

        log.debug("Avis {} créé !", avis.getId());

        return avis;
    }

    @Transactional
    public Avis save(String id, CreateOrUpdateAvisRequest request) {
        log.debug("Modification de l'avis {} ...", id);

        Avis avis = this.findById(id);

        avis = this.save(avis, request);

        log.debug("Avis {} modifié !", id);

        return avis;
    }

    @Transactional
    public void deleteById(String id) {
        log.debug("Suppression de l'avis {} ...", id);

        this.repository.deleteById(id);

        log.debug("Avis {} supprimé !", id);
    }

    private Avis save(Avis avis, CreateOrUpdateAvisRequest request) {
        if (avis.getDate() == null) {
            avis.setDate(LocalDateTime.now());
        }

        avis.setNote(request.getNote());
        avis.setCommentaire(request.getCommentaire());

        avis.setLivre(this.livreRepository.findById(request.getLivreId()));

        this.repository.persist(avis);

        log.debug("Avis {} persisté!", avis.getId());

        return avis;
    }
}
