package fr.bibliotek.api;

import java.util.List;

import org.jboss.resteasy.reactive.RestResponse.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.bibliotek.api.request.CreateOrUpdateAvisRequest;
import fr.bibliotek.api.response.AvisResponse;
import fr.bibliotek.api.response.EntityCreatedResponse;
import fr.bibliotek.api.response.EntityUpdatedResponse;
import fr.bibliotek.service.AvisService;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/avis")
public class AvisResource {
    private static final Logger log = LoggerFactory.getLogger(AvisResource.class);
    private final AvisService service;

    public AvisResource(AvisService service) {
        this.service = service;
    }

    @GET
    public List<AvisResponse> findAll() {
        log.debug("Listing avis ...");

        return this.service.findAll().map(AvisResponse::convert).toList();
    }

    @Path("/{id}")
    @GET
    public AvisResponse findById(@PathParam("id") String id) {
        log.debug("Finding avis {} ...", id);

        return AvisResponse.convert(this.service.findById(id));
    }

    @POST
    public Response create(@Valid CreateOrUpdateAvisRequest request) {
        log.debug("Creating new avis ...");

        return Response.status(Status.CREATED)
            .entity(new EntityCreatedResponse(this.service.save(request).getId()))
            .build()
        ;
    }

    @Path("/{id}")
    @PUT
    public EntityUpdatedResponse update(@PathParam("id") String id, @Valid CreateOrUpdateAvisRequest request) {
        log.debug("Updating avis {} ...", id);

        this.service.save(id, request);

        return new EntityUpdatedResponse(id, true);
    }

    @Path("/{id}")
    @DELETE
    public void deleteById(@PathParam("id") String id) {
        log.debug("Deleting avis {} ...", id);

        this.service.deleteById(id);
    }
}
