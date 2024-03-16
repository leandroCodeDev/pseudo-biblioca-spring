package com.api.library.controllers;


import com.api.library.dtos.LivroRecord;
import com.api.library.models.LivroModel;
import com.api.library.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<LivroModel>> getAllLivros() {
        List<LivroModel> livros;
        livros = livroService.findAllLivros();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LivroModel>> getAllLivros( @PathVariable("id") Long id) {
        Optional<LivroModel> livro;
        livro = livroService.findLivro(id);
        return new ResponseEntity<>(livro, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LivroRecord> saveLivro(@RequestBody LivroRecord livro) {
        LivroRecord savedLivro = livroService.saveLivro(livro);
        return new ResponseEntity<>(savedLivro, HttpStatus.CREATED);
    }
}