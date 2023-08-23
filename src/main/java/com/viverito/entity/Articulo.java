package com.viverito.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "articulo_id")
    private Long articulo_id;

    @Column(name = "nombre")
    @NotEmpty
    private String nombre;

    @Column(name = "precio")
    private Integer precio;

    @Column(name = "stock")
    private Integer stock;
    
    @Column (name = "imagen")
    private String imagen;
}
