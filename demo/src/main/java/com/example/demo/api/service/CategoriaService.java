package com.example.demo.api.service;

import com.example.demo.api.dto.CategoriaDto;
import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public List<CategoriaEntity> listarTodas() {
        return categoriaRepository.findAll();
    }


    public CategoriaEntity incluir(CategoriaDto dto) {
        CategoriaEntity categoriaEntity = CategoriaEntity.builder()
                .nome(dto.getNome())
                .build();
        return categoriaRepository.save(categoriaEntity);
    }


    public CategoriaEntity alterar(Long id, CategoriaDto dto) {
        CategoriaEntity categoriaEntity = categoriaRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        categoriaEntity.setNome(dto.getNome());
        return categoriaRepository.save(categoriaEntity);
    }

    // Deletar uma categoria
    public ResponseEntity<Void> deletar(Long id) {
        categoriaRepository.deleteById(Math.toIntExact(id));
        return ResponseEntity.ok().build();
    }

    // Buscar uma categoria por ID
    public CategoriaEntity categoriaFindById(Long id) {
        return categoriaRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }
}
