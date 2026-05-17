package com.biblioteca.api.controller;

import com.biblioteca.api.entity.Livro;
import com.biblioteca.api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public ResponseEntity<Iterable<Livro>> listarTodos() {
        Iterable<Livro> livros = livroRepository.findAll();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro) {
        Livro livroSalvo = livroRepository.save(livro);
        return new ResponseEntity<>(livroSalvo, HttpStatus.CREATED);
    }
}
