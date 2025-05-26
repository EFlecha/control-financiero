package com.example.demo.controllers;

import com.example.demo.models.Empleados;
import com.example.demo.services.EmpleadosService;
import com.example.demo.repositories.BarriosRepository;
import com.example.demo.repositories.CiudadesRepository;
import com.example.demo.repositories.NacionalidadRepository;
import com.example.demo.repositories.EstadoCivilRepository;
import com.example.demo.repositories.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/empleados")
public class EmpleadosController {
	
	@Autowired
    private EmpleadosService empleadosService;

    @Autowired
    private BarriosRepository barriosRepository;

    @Autowired
    private NacionalidadRepository nacionalidadRepository;

    @Autowired
    private EstadoCivilRepository estadoCivilRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @GetMapping
    public String listar(Model modelo) {
        modelo.addAttribute("empleados", empleadosService.getAllEmpleados());
        return "empleados/listar";
    }

    @GetMapping("/form")
    public String formularioNuevoEmpleado(Model modelo) {
        modelo.addAttribute("empleado", new Empleados());
        modelo.addAttribute("barrios", barriosRepository.findAll());
        modelo.addAttribute("nacionalidades", nacionalidadRepository.findAll());
        modelo.addAttribute("estadosCiviles", estadoCivilRepository.findAll());
        modelo.addAttribute("usuarios", usuariosRepository.findAll());
        return "empleados/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("empleado") Empleados empleado) {
        empleadosService.saveEmpleados(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model modelo) {
        empleadosService.getEmpleadoById(id).ifPresent(empleado -> modelo.addAttribute("empleado", empleado));
        modelo.addAttribute("barrios", barriosRepository.findAll());
        modelo.addAttribute("nacionalidades", nacionalidadRepository.findAll());
        modelo.addAttribute("estadosCiviles", estadoCivilRepository.findAll());
        modelo.addAttribute("usuarios", usuariosRepository.findAll());
        return "empleados/formulario";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer id) {
        empleadosService.deleteEmpleados(id);
        return "redirect:/empleados";
    }
    
    //prueba
    @GetMapping("/test-formulario")
        public String testFormularioTemplate() {
       	return "empleados/formulario";
    }

}
