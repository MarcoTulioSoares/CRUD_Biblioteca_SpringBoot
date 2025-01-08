package com.example.demo.api.service;

import com.example.demo.api.dto.LivroDto;
import com.example.demo.api.model.LivroEntity;
import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.repository.LivroRepository;
import com.example.demo.api.repository.AutorRepository;
import com.example.demo.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    public List<LivroEntity> listarTodos() {
        return livroRepository.findAll();
    }


    public LivroEntity incluir(LivroDto dto) {
        AutorEntity autorEntity = autorRepository.findById(Math.toIntExact(dto.getAutorDto().getId()))
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
        CategoriaEntity categoriaEntity = categoriaRepository.findById(Math.toIntExact(dto.getCategoriaDto().getId()))
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));


        LivroEntity livroEntity = LivroEntity.builder()
                .titulo(dto.getTitulo())
                .isbn(dto.getIsbn())
                .autor(autorEntity)
                .categoria(categoriaEntity)
                .build();


        return livroRepository.save(livroEntity);
    }


    public LivroEntity alterar(Integer id, LivroDto dto) {
        LivroEntity livroEntity = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        AutorEntity autorEntity = autorRepository.findById(Math.toIntExact(dto.getAutorDto().getId()))
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
        CategoriaEntity categoriaEntity = categoriaRepository.findById(Math.toIntExact(dto.getCategoriaDto().getId()))
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        livroEntity.setTitulo(dto.getTitulo());
        livroEntity.setIsbn(dto.getIsbn());
        livroEntity.setAutor(autorEntity);
        livroEntity.setCategoria(categoriaEntity);


        return livroRepository.save(livroEntity);
    }


    public ResponseEntity<Void> deletar(Integer id) {
        livroRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


    public LivroEntity livroFindById(Integer id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }
}
