package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Ciudades;
import com.example.demo.models.Departamentos;
import com.example.demo.repositories.DepartamentosRepository;
import com.example.demo.services.CiudadesService;

@Controller
@RequestMapping("/ciudades")
public class CiudadesController {
	
	@Autowired
    private CiudadesService ciudadesService;

    @Autowired
    private DepartamentosRepository departamentosRepository;

    @GetMapping
    public String listar(Model modelo) {
        modelo.addAttribute("ciudades", ciudadesService.getAllCiudades());
        return "ciudades/listar";
    }

    @GetMapping("/form")
    public String formularioNuevaCiudad(Model modelo) {
        modelo.addAttribute("ciudad", new Ciudades());
        modelo.addAttribute("departamentos", departamentosRepository.findAll());
        return "ciudades/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("ciudad") Ciudades ciudad) {
        ciudadesService.saveCiudades(ciudad);
        return "redirect:/ciudades";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model modelo) {
        ciudadesService.getCiudadById(id).ifPresent(ciudad -> modelo.addAttribute("ciudad", ciudad));
        modelo.addAttribute("departamentos", departamentosRepository.findAll());
        return "ciudades/formulario";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer id) {
        ciudadesService.deleteCiudades(id);
        return "redirect:/ciudades";
    }

}
