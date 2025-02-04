package com.sesi.projetos.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido {
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<Itemdopedido> items = new HashSet<>();
	public Set<Itemdopedido> getltems(){
		return items;}
	public List<Produto>getProduto(){
		return items.stream().map(x->x.getProduto()).toList();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant momento;
	private Status statusdopedido;
	
	@ManyToOne
	@JoinColumn(name = "Cliente_id")
	private Usuario cliente;
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	public Pedido() {
		
	}
	
	public Pedido(Long id, Instant momento, Status statusdopedido) {
		this.id = id;
		this.momento = momento;
		this.statusdopedido = statusdopedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public Status getStatusdopedido() {
		return statusdopedido;
	}

	public void setStatusdopedido(Status statusdopedido) {
		this.statusdopedido = statusdopedido;
	}
	
	
	
	

}
