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
@Table(name = "TB_CLIENTE")
public class ClienteEntity {

    private static final long serialVersionUID = 6916365966042464265L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CLIENTE")
    private Integer id;


    @Column(name = "NOME", nullable = false, length = 60)
    private String nome;

    @Column(name = "STATUS", nullable = false, length = 1)
    private String status;
}
