package com.example.demo.api.repository;

import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Integer> {
}
