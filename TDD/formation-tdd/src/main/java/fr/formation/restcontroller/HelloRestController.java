package fr.formation.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.model.Hello;

@RestController
@RequestMapping("/api/hello")
public class HelloRestController {
    @GetMapping
    public List<Hello> findAll() {
        return null;
    }
}
