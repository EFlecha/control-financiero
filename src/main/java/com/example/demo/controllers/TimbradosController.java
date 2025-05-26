package com.example.demo.controllers;

import com.example.demo.models.Timbrados;
import com.example.demo.repositories.TipoDocumentoRepository;
import com.example.demo.repositories.SucursalesRepository;
import com.example.demo.repositories.CajasRepository;
import com.example.demo.services.TimbradosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/timbrados")
public class TimbradosController {

    @Autowired
    private TimbradosService timbradosService;

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    private SucursalesRepository sucursalesRepository;

    @Autowired
    private CajasRepository cajasRepository;

    @GetMapping
    public String listar(Model modelo) {
        modelo.addAttribute("timbrados", timbradosService.getAllTimbrados());
        return "timbrados/listar";
    }

    @GetMapping("/form")
    public String nuevo(Model modelo) {
        modelo.addAttribute("timbrado", new Timbrados());
        modelo.addAttribute("tiposDocumento", tipoDocumentoRepository.findAll());
        modelo.addAttribute("sucursales", sucursalesRepository.findAll());
        modelo.addAttribute("cajas", cajasRepository.findAll());
        return "timbrados/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("timbrado") Timbrados timbrado) {
        timbradosService.saveTimbrado(timbrado);
        return "redirect:/timbrados";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model modelo) {
        timbradosService.getTimbradoById(id).ifPresent(t -> modelo.addAttribute("timbrado", t));
        modelo.addAttribute("tiposDocumento", tipoDocumentoRepository.findAll());
        modelo.addAttribute("sucursales", sucursalesRepository.findAll());
        modelo.addAttribute("cajas", cajasRepository.findAll());
        return "timbrados/formulario";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer id) {
        timbradosService.deleteTimbrado(id);
        return "redirect:/timbrados";
    }
}
