package com.sesi.projetos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sesi.projetos.entities.Itemdopedido;

@Repository
public interface ItemdopedidoRepository extends JpaRepository<Itemdopedido, Long>{

}
