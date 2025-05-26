package com.example.demo.controllers;

import com.example.demo.models.Mercaderias;
import com.example.demo.repositories.MarcasRepository;
import com.example.demo.repositories.ProcedenciasRepository;
import com.example.demo.repositories.TipoImpuestoRepository;
import com.example.demo.services.MercaderiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mercaderias")

public class MercaderiasController {
	
	@Autowired
    private MercaderiasService mercaderiasService;

    @Autowired
    private MarcasRepository marcasRepository;

    @Autowired
    private TipoImpuestoRepository tipoImpuestoRepository;

    @Autowired
    private ProcedenciasRepository procedenciasRepository;

    @GetMapping
    public String listar(Model modelo) {
        modelo.addAttribute("mercaderias", mercaderiasService.getAllMercaderias());
        return "mercaderias/listar";
    }

    @GetMapping("/form")
    public String formularioNuevo(Model modelo) {
        modelo.addAttribute("mercaderia", new Mercaderias());
        modelo.addAttribute("marcas", marcasRepository.findAll());
        modelo.addAttribute("tiposImpuesto", tipoImpuestoRepository.findAll());
        modelo.addAttribute("procedencias", procedenciasRepository.findAll());
        return "mercaderias/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("mercaderia") Mercaderias mercaderia) {
        mercaderiasService.saveMercaderia(mercaderia);
        return "redirect:/mercaderias";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model modelo) {
        mercaderiasService.getMercaderiaById(id).ifPresent(mercaderia -> modelo.addAttribute("mercaderia", mercaderia));
        modelo.addAttribute("marcas", marcasRepository.findAll());
        modelo.addAttribute("tiposImpuesto", tipoImpuestoRepository.findAll());
        modelo.addAttribute("procedencias", procedenciasRepository.findAll());
        return "mercaderias/formulario";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer id) {
        mercaderiasService.deleteMercaderia(id);
        return "redirect:/mercaderias";
    }

}
