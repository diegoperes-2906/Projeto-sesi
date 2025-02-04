package com.sesi.projetos.entities;

import org.springframework.data.annotation.Id;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_itemdopedido")
public class Itemdopedido {
	
	@EmbeddedId
	private ItemdopedidoPk id = new ItemdopedidoPk();
	private Integer quantidade;
	private Double preco;
	
	    public Itemdopedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Pedido getPedido() {
		return id.getPedido(); }
		
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido); }
	
	public Produto getProduto() {
		return id.getProduto(); }
		
	public void setProduto(Produto produto) {
		id.setProduto(produto); }

}
