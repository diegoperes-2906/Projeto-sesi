package com.sesi.projetos.entities;

import com.sesi.projetos.dto.ProdutoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private double preço;
	private String descrição;
	
	
	public Produto() {
		
	}
	
	public Produto(ProdutoDTO d) {
		this.nome = d.nome();
		this.preco = d.preco();
		this.descricao = d.descricao();
	}
	public Produto(long id, String nome, double preço, String descrição) {
		super();
		this.id = id;
		this.nome = nome;
		this.preço = preço;
		this.descrição = descrição;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreço() {
		return preço;
	}
	public void setPreço(double preço) {
		this.preço = preço;
	}
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	
	
	

}
