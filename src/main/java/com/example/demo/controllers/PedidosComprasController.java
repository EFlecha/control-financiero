package com.example.demo.controllers;

import com.example.demo.models.*;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedidos-compras")
public class PedidosComprasController {
	
	@Autowired
    private PedidoComprasService pedidoService;

    @Autowired
    private ProveedoresService proveedoresService;

    @Autowired
    private EmpleadosService empleadosService;

    @Autowired
    private CondicionService condicionPagoService;

    @Autowired
    private MercaderiasService mercaderiasService;

    @Autowired
    private SucursalesService sucursalesService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pedidos", pedidoService.getAll());
        return "pedidos-compras/listar";
    }

    @GetMapping("/form")
    public String nuevoPedido(Model model) {
        PedidoCompras pedido = new PedidoCompras();
        model.addAttribute("pedido", pedido);
        model.addAttribute("proveedores", proveedoresService.getAllProveedores());
        model.addAttribute("empleados", empleadosService.getAllEmpleados());
        model.addAttribute("condiciones", condicionPagoService.getAll());
        model.addAttribute("sucursales", sucursalesService.getAlls());
        model.addAttribute("mercaderias", mercaderiasService.getAllMercaderias());
        return "pedidos-compras/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("pedido") PedidoCompras pedido) {
        if (pedido.getDetalles() != null) {
            pedido.getDetalles().forEach(d -> d.setPedido(pedido));
        }
        pedidoService.save(pedido);
        return "redirect:/pedidos-compras";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        pedidoService.getById(id).ifPresent(pedido -> model.addAttribute("pedido", pedido));
        model.addAttribute("proveedores", proveedoresService.getAllProveedores());
        model.addAttribute("empleados", empleadosService.getAllEmpleados());
        model.addAttribute("condiciones", condicionPagoService.getAll());
        model.addAttribute("sucursales", sucursalesService.getAlls());
        model.addAttribute("mercaderias", mercaderiasService.getAllMercaderias());
        return "pedidos-compras/formulario";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer id) {
        pedidoService.delete(id);
        return "redirect:/pedidos-compras";
    }

}
