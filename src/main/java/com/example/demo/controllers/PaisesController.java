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

import com.example.demo.models.Paises;
import com.example.demo.services.PaisesService;

@Controller
@RequestMapping("/paises")
public class PaisesController {
	
	@Autowired
    private PaisesService paisesService;

    @GetMapping
    public String listar(Model modelo) {
        modelo.addAttribute("paises", paisesService.getAllPaises());
        return "paises/listar";
    }

    @GetMapping("/form")
    public String formularioNuevoPais(Model modelo) {
        modelo.addAttribute("pais", new Paises());
        return "paises/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("pais") Paises pais) {
        paisesService.savePaises(pais);
        return "redirect:/paises";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model modelo) {
        paisesService.getPaisById(id).ifPresent(pais -> modelo.addAttribute("pais", pais));
        return "paises/formulario";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer id) {
        paisesService.deletePaises(id);
        return "redirect:/paises";
    }

}
