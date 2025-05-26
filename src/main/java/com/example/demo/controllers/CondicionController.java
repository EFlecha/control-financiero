package com.example.demo.controllers;

import com.example.demo.models.Condicion;
import com.example.demo.services.CondicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/condicion")
public class CondicionController {
	
	@Autowired
    private CondicionService condicionService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", condicionService.getAll());
        return "condicion/listar";
    }

    @GetMapping("/form")
    public String formulario(Model model) {
        model.addAttribute("condicion", new Condicion());
        return "condicion/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Condicion condicion) {
        condicionService.save(condicion);
        return "redirect:/condicion";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("condicion", condicionService.getById(id));
        return "condicion/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        condicionService.deleteById(id);
        return "redirect:/condicion";
    }

}
