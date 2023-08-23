package com.viverito.repository;

import com.viverito.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDao extends JpaRepository<Pedido, Long>{

}
