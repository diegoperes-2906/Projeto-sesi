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

import com.sesi.projetos.dto.ProdutoDTO;
import com.sesi.projetos.entities.Produto;
import com.sesi.projetos.repository.ProdutoRepository;

@RestController 
@RequestMapping("produto")
public class ProdutoController {

	@Autowired
	ProdutoRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Produto>> mostrarTodos(){
		List<Produto> prod = repo.findAll();
		return ResponseEntity.ok(prod);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> mostrarPorId(@PathVariable Long id) {
		Produto prod = repo.getById(id);
		return ResponseEntity.ok(prod);
	}
	
	@PostMapping
	public ResponseEntity<Produto> criar(@RequestBody ProdutoDTO dto){
		Produto prod = new Produto(dto);
		return ResponseEntity.ok(prod);
	}
}
