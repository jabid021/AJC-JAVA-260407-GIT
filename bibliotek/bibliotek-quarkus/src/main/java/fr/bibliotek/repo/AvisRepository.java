package fr.bibliotek.repo;

import fr.bibliotek.model.Avis;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AvisRepository implements PanacheRepositoryBase<Avis, String> {

}
