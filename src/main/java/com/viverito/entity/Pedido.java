package com.viverito.entity;

import com.viverito.entity.Articulo;
import com.viverito.entity.Cliente;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "pedido")
public class Pedido  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private long id;
    
    @Column(name = "unidades")
    private int unidades;
    
    @Column(name = "precio_total")
    private double precio_total;
    
    @Column(name = "fecha")
    private String fecha;
    
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
