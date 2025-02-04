package com.sesi.projetos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesi.projetos.dto.CategoriaDTO;
import com.sesi.projetos.entities.Categoria;
import com.sesi.projetos.repository.CategoriaRepository;

@RestController 
@RequestMapping("categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> mostrarTodos(){
		List<Categoria> cate = repo.findAll();
		return ResponseEntity.ok(cate);
}
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> mostrarPorId(@PathVariable Long id) {
	Categoria cate = repo.getById(id);
	return ResponseEntity.ok(cate);
}
    @PostMapping
	public ResponseEntity<Categoria> criar(@RequestBody CategoriaDTO dto){
		Categoria cate = new Categoria(dto);
		return ResponseEntity.ok(cate);
    }}