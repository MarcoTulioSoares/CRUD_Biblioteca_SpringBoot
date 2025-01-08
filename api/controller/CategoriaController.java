package com.example.demo.api.controller;

import com.example.demo.api.dto.CategoriaDto;
import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaEntity>> listarTodas() {
        List<CategoriaEntity> lista = categoriaService.listarTodas();
        return ResponseEntity.ok(lista);
    }


    @PostMapping("/incluir")
    public ResponseEntity<Void> incluir(@RequestBody CategoriaDto categoriaDto) {
        CategoriaEntity categoriaEntity = categoriaService.incluir(categoriaDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoriaEntity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @PutMapping("/alterar/{id}")
    public ResponseEntity<CategoriaEntity> alterar(@PathVariable Long id, @RequestBody CategoriaDto categoriaDto) {
        CategoriaEntity categoriaAtualizada = categoriaService.alterar(id, categoriaDto);
        return ResponseEntity.ok(categoriaAtualizada);
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoriaEntity> categoriaFindById(@PathVariable("id") Long id) {
        CategoriaEntity categoria = categoriaService.categoriaFindById(id);
        return ResponseEntity.ok(categoria);
    }
}
