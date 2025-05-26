package com.example.demo.controllers;

import com.example.demo.models.Barrios;
import com.example.demo.models.Ciudades;
import com.example.demo.repositories.CiudadesRepository;
import com.example.demo.services.BarriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/barrios")
public class BarriosController {
	
	@Autowired
    private BarriosService barriosService;

    @Autowired
    private CiudadesRepository ciudadesRepository;

    @GetMapping
    public String listar(Model modelo) {
        modelo.addAttribute("barrios", barriosService.getAllBarrios());
        return "barrios/listar";
    }

    @GetMapping("/form")
    public String formularioNuevoBarrio(Model modelo) {
        modelo.addAttribute("barrio", new Barrios());
        modelo.addAttribute("ciudades", ciudadesRepository.findAll());
        return "barrios/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("barrio") Barrios barrio) {
        barriosService.saveBarrios(barrio);
        return "redirect:/barrios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model modelo) {
        barriosService.getBarrioById(id).ifPresent(barrio -> modelo.addAttribute("barrio", barrio));
        modelo.addAttribute("ciudades", ciudadesRepository.findAll());
        return "barrios/formulario";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer id) {
        barriosService.deleteBarrios(id);
        return "redirect:/barrios";
    }

}
