package com.example.demo.api.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutorDto {

    private Long id;
    private String nome;
    private String nacionalidade;
}
