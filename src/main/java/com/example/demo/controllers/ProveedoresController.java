package com.example.demo.controllers;

import com.example.demo.models.Proveedores;
import com.example.demo.repositories.BarriosRepository;
import com.example.demo.services.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/proveedores")
public class ProveedoresController {
	
	@Autowired
    private ProveedoresService proveedoresService;

    @Autowired
    private BarriosRepository barriosRepository;

    @GetMapping
    public String listar(Model modelo) {
        modelo.addAttribute("proveedores", proveedoresService.getAllProveedores());
        return "proveedores/listar";
    }

    @GetMapping("/form")
    public String formularioNuevo(Model modelo) {
        modelo.addAttribute("proveedor", new Proveedores());
        modelo.addAttribute("barrios", barriosRepository.findAll());
        modelo.addAttribute("tiposPersona", List.of("FIS", "JUR")); 
        return "proveedores/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("proveedor") Proveedores proveedor) {
        proveedoresService.saveProveedor(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model modelo) {
    	proveedoresService.getProveedorById(id).ifPresent(proveedor -> modelo.addAttribute("proveedor", proveedor));
        modelo.addAttribute("barrios", barriosRepository.findAll());
        modelo.addAttribute("tiposPersona", List.of("FIS", "JUR"));
        return "proveedores/formulario";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer id) {
        proveedoresService.deleteProveedor(id);
        return "redirect:/proveedores";
    }

}
