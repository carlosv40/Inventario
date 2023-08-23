package com.viverito.controller;

import com.viverito.entity.Pedido;
import com.viverito.entity.Articulo;
import com.viverito.repository.ArticuloDao;
import com.viverito.entity.Cliente;
import com.viverito.repository.ClienteDao;
import com.viverito.repository.PedidoDao;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class PedidoController {

    @Autowired
    private PedidoDao pedidoService;
    
    @Autowired
    private ClienteDao clienteService;
    
    @Autowired
    private ArticuloDao articuloService;

    @GetMapping("/pedido")
    public String listarPedidos(Model model) {
        var pedidos = pedidoService.findAll();

        log.info("Ejecutando el controlador de pedidos");

        model.addAttribute("pedidos", pedidos);
        return "pedido";
    }

    @GetMapping("/agregarP")
    public String agregarPedidos(Model model) {
        List<Cliente> clientes = clienteService.findAll();
        List<Articulo> articulos = articuloService.findAll();
        
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("clientes", clientes);
        model.addAttribute("articulos", articulos);
        return "modificarP";
    }

    @PostMapping("/guardarP")
    public String guardarPedido(Pedido pedido) {
        pedidoService.save(pedido);
        return "redirect:/pedido";
    }

    @GetMapping("/editarP/{id}")
    public String editarPedido(Pedido pedido, Model model) {
        pedido = pedidoService.findById(pedido.getId()).orElse(null);
        List<Cliente> clientes = clienteService.findAll();
        List<Articulo> articulos = articuloService.findAll();
        
        model.addAttribute("pedido", pedido);
        model.addAttribute("clientes", clientes);
        model.addAttribute("articulos", articulos);
        return "modificarP";
    }

    @GetMapping("/eliminarP")
    public String eliminarPedido(Pedido pedido) {
        pedidoService.delete(pedido);
        return "redirect:/pedido";
    }
}
