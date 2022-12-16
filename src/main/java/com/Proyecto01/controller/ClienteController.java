package com.Proyecto01.controller;

import com.Proyecto01.domain.Cliente;
import com.Proyecto01.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    //Provoca que el objeto se cree si no exites o se use el que existe
    //Se conoce como inyección de independencias
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente/agregar")
    public String inicio(Model model) {

        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        
      
        model.addAttribute("totalClientes",clientes.size());
        
        model.addAttribute("clientes",clientes);
        return "/cliente/agregar";
        
    }

    //Para poder ubicar el URL de cliente nuevo
    @GetMapping("/cliente/nuevo")
    public String clienteNuevo(Cliente cliente) {

        return "/cliente/modificar";

    }

    //Para poder ubicar el URL de Busqueda de cliente
    @GetMapping("/cliente/busqueda")
    public String clienteBusqueda(Cliente cliente) {

        return "/cliente/busqueda";

    }
    

    

    //Mapeo para guardar cliente
    @PostMapping("/cliente/guardar")
    public String clienteGuardar(Cliente cliente) {

        clienteService.save(cliente);
        //Esto es para que se vaya de nuevo al index
        return "redirect:/cliente/modificar";

    }

    //Mapeo para actualizar cliente
    @GetMapping("/cliente/actualiza/{idCliente}")
    public String clienteActualiza(Cliente cliente, Model model) {

        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";

    }

    //Mapeo para eliminar cliente
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String clienteElimina(Cliente cliente) {

        clienteService.delete(cliente);
        return "redirect:/cliente/agregar";

    }

}
