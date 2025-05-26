package com.example.demo.controllers;

import com.example.demo.models.*;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/ordenes")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @Autowired
    private PresupuestoCompraService presupuestoCompraService;

    @Autowired
    private ProveedoresService proveedoresService;

    @Autowired
    private EmpleadosService empleadosService;

    @Autowired
    private SucursalesService sucursalesService;

    @Autowired
    private CondicionService condicionService;

    @Autowired
    private MercaderiasService mercaderiasService;

    @GetMapping
    public String listar(Model model) {
        List<OrdenCompra> lista = ordenCompraService.getAll();
        model.addAttribute("lista", lista);
        return "ordenes/listar";
    }

    @GetMapping("/form")
    public String formulario(Model model) {
        model.addAttribute("ordenCompra", new OrdenCompra());
        model.addAttribute("presupuestos", presupuestoCompraService.getAll());
        model.addAttribute("proveedores", proveedoresService.getAllProveedores());
        model.addAttribute("empleados", empleadosService.getAllEmpleados());
        model.addAttribute("sucursales", sucursalesService.getAlls());
        model.addAttribute("condiciones", condicionService.getAll());
        model.addAttribute("mercaderias", mercaderiasService.getAllMercaderias());
        return "ordenes/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute OrdenCompra ordenCompra) {
        ordenCompra.setFecha(LocalDate.now());
        ordenCompraService.save(ordenCompra);
        return "redirect:/ordenes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        OrdenCompra orden = ordenCompraService.getById(id);
        model.addAttribute("ordenCompra", orden);
        model.addAttribute("presupuestos", presupuestoCompraService.getAll());
        model.addAttribute("proveedores", proveedoresService.getAllProveedores());
        model.addAttribute("empleados", empleadosService.getAllEmpleados());
        model.addAttribute("sucursales", sucursalesService.getAlls());
        model.addAttribute("condiciones", condicionService.getAll());
        model.addAttribute("mercaderias", mercaderiasService.getAllMercaderias());
        return "ordenes/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        ordenCompraService.delete(id);
        return "redirect:/ordenes";
    }
}

