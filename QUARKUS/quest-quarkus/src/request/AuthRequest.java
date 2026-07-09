package fr.formation.request;

public record AuthRequest(String username, String password) {

}

// public class AuthRequest {
//     private final String username;
//     private final String password;

//     public AuthRequest(String username, String password) {
//         this.username = username;
//         this.password = password;
//     }

//     public String username() {
//         return this.username;
//     }

//     public String password() {
//         return this.password;
//     }
// }
