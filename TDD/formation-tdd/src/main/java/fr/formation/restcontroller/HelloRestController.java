package fr.formation.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.model.Hello;
import fr.formation.repo.HelloRepository;

@RestController
@RequestMapping("/api/hello")
public class HelloRestController {
    @Autowired
    private HelloRepository repository;

    @GetMapping
    public List<Hello> findAll() {
        return this.repository.findAll();
    }
}
