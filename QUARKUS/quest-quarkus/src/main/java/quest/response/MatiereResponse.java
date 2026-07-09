package quest.response;

import java.math.BigDecimal;

import quest.model.Matiere;

public class MatiereResponse {
    private int id;
    private String libelle;
    private BigDecimal prix;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public static MatiereResponse convert(Matiere Matiere) {
        MatiereResponse resp = new MatiereResponse();

        resp.setId(Matiere.getId());
        resp.setLibelle(Matiere.getLibelle());

        return resp;
    }
}
