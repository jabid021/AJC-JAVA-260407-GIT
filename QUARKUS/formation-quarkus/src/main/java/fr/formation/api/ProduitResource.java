package fr.formation.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Produit;
import fr.formation.request.CreateOrUpdateProduitRequest;
import fr.formation.response.ProduitResponse;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/api/produit")
public class ProduitResource {
    private List<Produit> produits = new ArrayList<>();
    private int lastId = 2;

    public ProduitResource() {
        produits.add(new Produit(1, "Parachute", new BigDecimal("9850")));
        produits.add(new Produit(2, "Casque", new BigDecimal("499")));
    }

    @GET
    public List<ProduitResponse> findAll() {
        return this.produits
            .stream()
            .map(ProduitResponse::convert)
            .toList()
        ;
    }

    @POST
    public int create(CreateOrUpdateProduitRequest request) {
        Produit produit = new Produit();

        produit.setLibelle(request.getLibelle());
        produit.setPrix(request.getPrix());

        produit.setId(++this.lastId);

        this.produits.add(produit);

        return this.lastId;
    }

    @PUT
    @Path("/{id}")
    public int update(@PathParam("id") Integer id, CreateOrUpdateProduitRequest request) {
        Produit produit = this.produits.stream().filter(p -> p.getId() == id).findFirst().orElseThrow();

        produit.setLibelle(request.getLibelle());
        produit.setPrix(request.getPrix());

        return id;
    }

    @DELETE
    @Path("/{id}")
    public void deleteById(@PathParam("id") Integer id) {
        this.produits.removeIf(p -> p.getId() == id);
    }
}
