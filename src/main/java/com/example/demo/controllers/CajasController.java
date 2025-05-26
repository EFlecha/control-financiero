package com.example.demo.controllers;

import com.example.demo.models.Cajas;
import com.example.demo.services.CajasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cajas")
public class CajasController {
	
	@Autowired
    private CajasService cajasService;

    @GetMapping
    public String listar(Model modelo) {
        modelo.addAttribute("cajas", cajasService.getAll());
        return "cajas/listar";
    }

    @GetMapping("/form")
    public String nuevo(Model modelo) {
        modelo.addAttribute("caja", new Cajas());
        return "cajas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("caja") Cajas caja) {
        cajasService.save(caja);
        return "redirect:/cajas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model modelo) {
        cajasService.getById(id).ifPresent(caja -> modelo.addAttribute("caja", caja));
        return "cajas/formulario";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer id) {
        cajasService.delete(id);
        return "redirect:/cajas";
    }

}
