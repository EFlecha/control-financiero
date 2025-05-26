package com.example.demo.controllers;

import com.example.demo.models.TipoImpuesto;
import com.example.demo.repositories.TipoImpuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tipo_impuesto")
public class TipoImpuestoController {

    @Autowired
    private TipoImpuestoRepository tipoImpuestoRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", tipoImpuestoRepository.findAll());
        return "tipo_impuesto/listar";
    }

    @GetMapping("/form")
    public String formulario(Model model) {
        model.addAttribute("tipoImpuesto", new TipoImpuesto());
        return "tipo_impuesto/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute TipoImpuesto tipoImpuesto) {
        tipoImpuestoRepository.save(tipoImpuesto);
        return "redirect:/tipo_impuesto";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("tipoImpuesto", tipoImpuestoRepository.findById(id).orElse(null));
        return "tipo_impuesto/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        tipoImpuestoRepository.deleteById(id);
        return "redirect:/tipo_impuesto";
    }
}

