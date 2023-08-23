package com.viverito.controller;

import com.viverito.repository.ClienteDao;
import com.viverito.entity.Cliente;
import java.io.Serializable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ClienteController implements Serializable {

    @Autowired
    private ClienteDao clienteService;

    @GetMapping("/cliente")
    public String clientes(Model model) {
        var clientes = clienteService.findAll();

        log.info("Ejecutando el controlador de Clientes");
        model.addAttribute("clientes", clientes);
        return "Cliente";
    }

    @GetMapping("/agregarC")
    public String agregar(Cliente cliente) {
        return "modificarC";
    }

    @PostMapping("/guardarC")
    public String guardar(Cliente cliente) {

        clienteService.save(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/editarC/{cliente_id}")
    public String editar(Cliente cliente, Model model) {
        cliente = clienteService.findById(cliente.getCliente_id()).orElse(null);
        model.addAttribute("cliente", cliente);
        return "modificarC";
    }

    @GetMapping("/eliminarC")
    public String eliminar(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente";
    }
}
