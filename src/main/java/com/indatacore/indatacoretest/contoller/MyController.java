package com.indatacore.indatacoretest.contoller;

import com.indatacore.indatacoretest.domaine.Etudiant;
import com.indatacore.indatacoretest.service.MyService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class MyController {
    private MyService service;

    @Autowired
    public MyController(MyService service) {
        this.service = service;
    }


    @GetMapping
    public String testApi() {
        return "this is a test";
    }

    @GetMapping("/all")
    public Iterable<Etudiant> getAll() {

        return service.getAll();
    }

    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return service.addEtudiant(etudiant);
    }

    @PostMapping("/addRandom")
    public Etudiant addRandomEtudiant() {
        return service.addRandomEtudiant();
    }


}
