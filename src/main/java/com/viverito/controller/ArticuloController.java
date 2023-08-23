package com.viverito.controller;

import com.viverito.repository.ArticuloDao;
import com.viverito.entity.Articulo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ArticuloController {

    @Autowired
    private ArticuloDao articuloService;

    @GetMapping("/articulo")
    public String listarArticulos(Model modelo) {
        var articulos = articuloService.findAll();
        log.info("Ejecutando el controlador de productos");

        modelo.addAttribute("articulos", articulos);
        return "products";
    }
    
    @GetMapping("/articulo/agregar")
    public String agregarArticulo(Articulo articulo) {
        return "modificar";
    }
    
    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Model model, Articulo articulo){
        articuloService.save(articulo);
        var articulos = articuloService.findAll();
        model.addAttribute("articulos", articulos);
        return "products";
    }
    
    @GetMapping("/editar/{articulo_id}")
    public String editarArticulo(Articulo articulo, Model model){
        articulo = articuloService.findById(articulo.getArticulo_id()).orElse(null);
        model.addAttribute("articulo", articulo);
        return "modificar";
    }
    
    @GetMapping("/articulo/eliminar")
    public String eliminarArticulo(Articulo articulo){
        articuloService.delete(articulo);
        return "redirect:/articulo";
    }
}
