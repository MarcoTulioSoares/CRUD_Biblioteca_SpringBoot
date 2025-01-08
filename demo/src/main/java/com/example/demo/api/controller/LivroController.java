package com.example.demo.api.controller;

import com.example.demo.api.dto.LivroDto;
import com.example.demo.api.model.LivroEntity;
import com.example.demo.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;


    @GetMapping(value = "/listar")
    public ResponseEntity<List<LivroEntity>> listarTodos() {
        List<LivroEntity> lista = livroService.listarTodos();
        return ResponseEntity.ok(lista);
    }


    @PostMapping(value = "/incluir")
    public ResponseEntity<Void> incluir(@RequestBody LivroDto request) {
        LivroEntity livroEntity = livroService.incluir(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(livroEntity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @PutMapping("/alterar/{id}")
    public ResponseEntity<LivroEntity> alterar(@PathVariable Integer id, @RequestBody LivroDto request) {
        LivroEntity livroEntity = livroService.alterar(id, request);
        return ResponseEntity.ok().body(livroEntity);
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        livroService.deletar(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/livro/{id}")
    public ResponseEntity<LivroEntity> livroFindById(@PathVariable("id") Integer id) {
        LivroEntity livroEntity = livroService.livroFindById(id);
        return ResponseEntity.ok(livroEntity);
    }
}
