package com.example.demo.api.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivroDto {

    private Long id;
    private String titulo;
    private String isbn;
    private AutorDto autorDto;
    private CategoriaDto categoriaDto;

}
