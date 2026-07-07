package quest.dto.request;

import quest.model.Genre;

public record InscriptionRequest(String login, String password, String nom, String prenom, Genre civilite) {

}
