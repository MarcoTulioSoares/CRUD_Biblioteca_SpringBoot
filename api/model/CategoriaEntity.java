package com.example.demo.api.model;

import lombok.*;
import jakarta.persistence.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CATEGORIA")
public class CategoriaEntity {

    private static final long serialVersionUID = 6916365966042464265L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CATEGORIA")
    private Integer id;
    //private UUID id;

    @Column(name = "NOME", nullable = false, length = 60)
    private String nome;


}
