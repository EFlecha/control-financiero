package com.example.demo.controllers;

import com.example.demo.models.Cliente;
import com.example.demo.models.Barrios;
import com.example.demo.services.BarriosService;
import com.example.demo.services.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final BarriosService barrioService;

    public ClienteController(ClienteService clienteService, BarriosService barrioService) {
        this.clienteService = clienteService;
        this.barrioService = barrioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", clienteService.getAll());
        return "clientes/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("barrios", barrioService.getAllBarrios());
        return "clientes/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("cliente", clienteService.getById(id));
        model.addAttribute("barrios", barrioService.getAllBarrios());
        return "clientes/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        clienteService.delete(id);
        return "redirect:/clientes";
    }
}

