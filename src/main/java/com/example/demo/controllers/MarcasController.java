package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Marcas;
import com.example.demo.services.MarcasService;

@Controller
@RequestMapping("/marcas")
public class MarcasController {
	
	@Autowired
	private MarcasService marcasService;
	
	@GetMapping
	public String listar(Model modelo) {
		modelo.addAttribute("marcas", marcasService.getAllMarcas());
		return "marcas/listar";
	}

	@GetMapping("/form")
	public String formularioNuevaMarca(Model modelo) {
		modelo.addAttribute("marca", new Marcas());
		return "marcas/formulario";
	}

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Marcas marca) {
    	marcasService.saveMarcas(marca);
        return "redirect:/marcas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model modelo) {
        marcasService.getMarcaById(id).ifPresent(marca -> modelo.addAttribute("marca", marca));
        return "marcas/formulario";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer id) {
        marcasService.deleteMarcas(id);
        return "redirect:/marcas";
    }

}
