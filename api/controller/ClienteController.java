package com.example.demo.api.controller;

import com.example.demo.api.dto.AutorDto;
import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/autor")
public class ClienteController {

    @Autowired
    private AutorService autorService;


    @GetMapping(value = "/listar")
    public ResponseEntity<List<AutorEntity>> listarTodos() {
        List<AutorEntity> lista = autorService.listarTodos();
        return ResponseEntity.ok(lista);
    }


    @PostMapping(value = "/incluir")
    public ResponseEntity<Void> incluir(@RequestBody AutorDto request) {
        AutorEntity autorEntity = autorService.incluir(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(autorEntity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @PutMapping("/alterar/{id}")
    public ResponseEntity<AutorEntity> alterar(@PathVariable Integer id, @RequestBody AutorDto request) {
        AutorEntity autorEntity = autorService.alterar(id, request);
        return ResponseEntity.ok().body(autorEntity);
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        autorService.deletar(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/autor/{id}")
    public ResponseEntity<AutorEntity> autorFindById(@PathVariable("id") Integer id) {
        AutorEntity autorEntity = autorService.autorFindById(id);
        return ResponseEntity.ok(autorEntity);
    }
}
