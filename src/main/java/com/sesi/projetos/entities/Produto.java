package com.sesi.projetos.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sesi.projetos.dto.ProdutoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@OneToMany(mappedBy = "id.produto")
	private Set<Itemdopedido> items = new HashSet<>();
	public Set<Itemdopedido> gettltems(){
		return items;
	}
	
	public List<Pedido>getPedido(){
		return items.stream().map(x->x.getPedido()).toList();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private double preço;
	private String descrição;
	private String imgUrl;
	
	@ManyToMany
	@JoinTable(name = "tb_produto_categoria",
	joinColumns = @JoinColumn(name = "produto_id"),
	
	inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private Set<Categoria> categorias = new HashSet<>();
	
	public Produto(long id, String nome, double preço, String descrição, String imgUrl) {
		this.id = id;
		this.nome = nome;
		this.preço = preço;
		this.descrição = descrição;
		this.imgUrl = imgUrl;
	}
	public Produto(ProdutoDTO dto) {
		this.nome = dto.nome();
		this.preço = dto.preco();
		this.descrição = dto.descricao();
		this.imgUrl = dto.imgUrl();
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
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}}
	
	
