package fr.formation.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.security.JwtUtils;


@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
    @GetMapping
    public String auth() {
        return JwtUtils.generate();
    }
}
