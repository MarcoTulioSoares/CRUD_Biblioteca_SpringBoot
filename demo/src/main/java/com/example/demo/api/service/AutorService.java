package com.example.demo.api.service;

import com.example.demo.api.dto.AutorDto;
import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;


    public List<AutorEntity> listarTodos() {
        return autorRepository.findAll();
    }


    public AutorEntity incluir(AutorDto dto) {

        AutorEntity entity = AutorEntity.builder()
                .nome(dto.getNome())
                .nacionalidade(dto.getNacionalidade())
                .build();
        return autorRepository.save(entity);
    }


    public AutorEntity alterar(Integer id, AutorDto dto) {
        // Encontrar o autor pelo id
        AutorEntity objeto = autorFindById(id);
        objeto.setNome(dto.getNome());
        objeto.setNacionalidade(dto.getNacionalidade());
        return autorRepository.save(objeto);
    }


    public ResponseEntity deletar(Integer id) {
        autorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Buscar autor por ID
    public AutorEntity autorFindById(Integer id) {
        return autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado"));
    }
}
