package com.example.demo.controllers;

import com.example.demo.models.*;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/presupuestos")
public class PresupuestoCompraController {

    @Autowired
    private PresupuestoCompraService presupuestoService;

    @Autowired
    private PedidoComprasService pedidoComprasService;

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

    @Autowired
    private PresupuestoCompraDetalleService detalleService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", presupuestoService.getAll());
        return "presupuestos/listar";
    }

    @GetMapping("/form")
    public String formulario(Model model) {
        model.addAttribute("presupuesto", new PresupuestoCompra());
        model.addAttribute("pedidos", pedidoComprasService.getAll());
        model.addAttribute("proveedores", proveedoresService.getAllProveedores());
        model.addAttribute("empleados", empleadosService.getAllEmpleados());
        model.addAttribute("sucursales", sucursalesService.getAlls());
        model.addAttribute("condiciones", condicionService.getAll());
        model.addAttribute("mercaderias", mercaderiasService.getAllMercaderias());
        return "presupuestos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute PresupuestoCompra presupuesto) {
        presupuesto.setFecha(new Date());
        presupuestoService.save(presupuesto);
        return "redirect:/presupuestos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        PresupuestoCompra presupuesto = presupuestoService.getById(id);
        model.addAttribute("presupuesto", presupuesto);
        model.addAttribute("pedidos", pedidoComprasService.getAll());
        model.addAttribute("proveedores", proveedoresService.getAllProveedores());
        model.addAttribute("empleados", empleadosService.getAllEmpleados());
        model.addAttribute("sucursales", sucursalesService.getAlls());
        model.addAttribute("condiciones", condicionService.getAll());
        model.addAttribute("mercaderias", mercaderiasService.getAllMercaderias());
        return "presupuestos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        presupuestoService.deleteById(id);
        return "redirect:/presupuestos";
    }
}
