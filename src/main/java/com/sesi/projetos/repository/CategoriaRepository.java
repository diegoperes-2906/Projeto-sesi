package com.sesi.projetos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sesi.projetos.entities.Categoria;

@Repository	
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
