package com.example.demo.api.repository;

import com.example.demo.api.model.ClienteEntity;
import com.example.demo.api.model.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Integer> {
}
