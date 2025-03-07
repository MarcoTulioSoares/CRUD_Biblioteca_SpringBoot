package com.example.demo.api.repository;

import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {
}
