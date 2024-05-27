package com.labbackend.labbackendx.controller;

import com.labbackend.labbackendx.model.Doctorant;
import com.labbackend.labbackendx.repository.DoctorantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctorants")
public class DoctorantController {

    @Autowired
    private DoctorantRepository doctorantRepository;

    @GetMapping
    public List<Doctorant> getAllDoctorants() {
        return doctorantRepository.findAll();
    }

    @PostMapping
    public Doctorant createDoctorant(@RequestBody Doctorant doctorant) {
        return doctorantRepository.save(doctorant);
    }

    // Ajoutez d'autres méthodes pour la mise à jour, la suppression, etc.
}
