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

import com.example.demo.models.Bancos;
import com.example.demo.services.BancosService;

@Controller
@RequestMapping("/bancos")
public class BancosController {
	
	@Autowired
    private BancosService bancosService;

    @GetMapping
    public String listar(Model modelo) {
        modelo.addAttribute("bancos", bancosService.getAllBancos());
        return "bancos/listar";
    }

    @GetMapping("/form")
    public String formularioNuevoBanco(Model modelo) {
        modelo.addAttribute("banco", new Bancos());
        return "bancos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("banco") Bancos banco) {
        bancosService.saveBancos(banco);
        return "redirect:/bancos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model modelo) {
        bancosService.getBancoById(id).ifPresent(banco -> modelo.addAttribute("banco", banco));
        return "bancos/formulario";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer id) {
        bancosService.deleteBancos(id);
        return "redirect:/bancos";
    }

}
