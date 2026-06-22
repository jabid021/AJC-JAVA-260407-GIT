package fr.formation.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.restcontroller.dto.AuthRequest;
import fr.formation.security.JwtUtils;


@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
    @PostMapping
    public String auth(@RequestBody AuthRequest request) {
        System.out.println("Username = " + request.username());
        System.out.println("Password = " + request.password());

        return JwtUtils.generate();
    }
}
