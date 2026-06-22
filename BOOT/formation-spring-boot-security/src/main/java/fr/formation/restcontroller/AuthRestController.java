package fr.formation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.restcontroller.dto.AuthRequest;
import fr.formation.security.JwtUtils;


@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public String auth(@RequestBody AuthRequest request) {
        System.out.println("Username = " + request.username());
        System.out.println("Password = " + request.password());

        Authentication auth = new UsernamePasswordAuthenticationToken(request.username(), request.password());

        this.authenticationManager.authenticate(auth);

        System.out.println("OK C BON !!");

        return JwtUtils.generate();
    }
}
