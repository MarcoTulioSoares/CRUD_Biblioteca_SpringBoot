package com.example.demo.api.model;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_LIVRO")
@Entity
public class LivroEntity {

    private static final long serialVersionUID = 6916365966042464265L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Ajuste para MySQL
    @Column(name = "COD_LIVRO")
    private Integer id;
    //private UUID id;

    @Column(name = "TITULO", nullable = false, length = 60)
    private String titulo;

    @Column(name = "ISBN", nullable = false, length = 60)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "AUTOR_ID", nullable = false)
    private AutorEntity autor;

    @ManyToOne
    @JoinColumn(name = "CATEGORIA", nullable = false)
    private CategoriaEntity categoria;
}
