package fr.formation;

import java.util.Map;

import fr.formation.musique.Guitariste;
import fr.formation.request.ExempleBeanParamRequest;
import fr.formation.request.ExempleRequest;
import fr.formation.response.ExempleResponse;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/hello")
public class GreetingResource {
    private final Guitariste guitariste;

    // Injection par constructeur
    public GreetingResource(Guitariste guitariste) {
        this.guitariste = guitariste;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        this.guitariste.jouer();

        return "Hello from Quarkus REST (2)";
    }

    @GET
    @Path("/demo")
    public String demo() {
        return "Démonstration";
    }

    @GET
    @Path("/exemple")
    public ExempleResponse exemple(@QueryParam("message") String message) {
        return new ExempleResponse("Le contenu du message = " + message);
    }

    @GET
    @Path("/exemple/{message}")
    public ExempleResponse exemplePathParam(@PathParam("message") String message) {
        return new ExempleResponse("Le contenu du message = " + message);
    }

    @GET
    @Path("/exemple/bean-param")
    public String exempleBeanParam(@BeanParam ExempleBeanParamRequest request) {
        System.out.println(request.getLibelle());
        System.out.println(request.getPrix());

        return "ok";
    }

    @POST
    @Path("/exemple")
    public Response exemplePost(ExempleRequest request) {
        System.out.println(request.getLibelle());
        System.out.println(request.getPrix());

        return Response.status(Status.CREATED)
            .entity(Map.of("id", "valeur de l'id"))
            .build()
        ;
    }
}
