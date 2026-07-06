package fr.formation.api;

import java.util.List;

import fr.formation.model.Produit;
import fr.formation.repo.ProduitRepository;
import fr.formation.request.CreateOrUpdateProduitRequest;
import fr.formation.response.ProduitResponse;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/api/produit")
public class ProduitResource {
    private final ProduitRepository repository;

    public ProduitResource(ProduitRepository repository) {
        this.repository = repository;
    }

    @GET
    public List<ProduitResponse> findAll() {
        return this.repository.findAll()
            .stream()
            .map(ProduitResponse::convert)
            .toList()
        ;
    }

    @POST
    @Transactional
    public int create(CreateOrUpdateProduitRequest request) {
        Produit produit = new Produit();

        produit.setLibelle(request.getLibelle());
        produit.setPrix(request.getPrix());

        this.repository.persist(produit);

        return produit.getId();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public int update(@PathParam("id") Integer id, CreateOrUpdateProduitRequest request) {
        Produit produit = this.repository.findByIdOptional(id).orElseThrow(NotFoundException::new);

        produit.setLibelle(request.getLibelle());
        produit.setPrix(request.getPrix());

        this.repository.persist(produit);

        return id;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteById(@PathParam("id") Integer id) {
        this.repository.deleteById(id);
    }
}
