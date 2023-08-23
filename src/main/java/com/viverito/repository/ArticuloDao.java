package com.viverito.repository;

import com.viverito.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloDao extends JpaRepository<Articulo, Long>{
    
}
