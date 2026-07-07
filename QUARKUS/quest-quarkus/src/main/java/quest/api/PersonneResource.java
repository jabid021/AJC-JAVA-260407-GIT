package quest.api;

import java.util.Map;

import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import quest.dto.request.InscriptionRequest;
import quest.model.Stagiaire;
import quest.repo.PersonneRepository;

@Path("/api/personne")
public class PersonneResource {
    private final PersonneRepository repository;

    public PersonneResource(PersonneRepository repository) {
        this.repository = repository;
    }

    @POST
    @Path("/inscription")
    @Transactional
    public Response inscription(InscriptionRequest request) {
        Stagiaire stagiaire = new Stagiaire();

        stagiaire.setLogin(request.login());
        stagiaire.setPassword(BcryptUtil.bcryptHash(request.password()));

        stagiaire.setNom(request.nom());
        stagiaire.setPrenom(request.prenom());
        stagiaire.setCivilite(request.civilite());

        this.repository.persist(stagiaire);

        return Response
            .status(Status.CREATED)
            .entity(Map.of("id", stagiaire.getId()))
            .build()
        ;
    }
}
