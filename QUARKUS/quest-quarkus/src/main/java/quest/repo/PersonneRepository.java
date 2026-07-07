package quest.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import quest.model.Personne;

@ApplicationScoped
public class PersonneRepository implements PanacheRepositoryBase<Personne, Integer> {

}
