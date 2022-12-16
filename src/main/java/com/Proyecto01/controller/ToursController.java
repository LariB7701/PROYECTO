package com.Proyecto01.controller;

import com.Proyecto01.domain.Tours;
import com.Proyecto01.service.ToursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToursController {

    //Provoca que el objeto se cree si no exites o se use el que existe
    //Se conoce como inyección de independencias
    @Autowired
    private ToursService toursService;

    @GetMapping("/tours/destinos")
    public String inicio(Model model) {

        var tourss = toursService.getTourss();
        model.addAttribute("tourss", tourss);
        
      
        model.addAttribute("totalTourss",tourss.size());
        
        model.addAttribute("tourss",tourss);
        return "/tours/destinos";
          
    }

    //Para poder ubicar el URL de tours nuevo
    @GetMapping("/tours/nuevo")
    public String toursNuevo(Tours tours) {

        return "/tours/modificar";

    }

    //Para poder ubicar el URL de Busqueda de tours
    @GetMapping("/tours/busqueda")
    public String toursBusqueda(Tours tours) {

        return "/tours/modificar";

    }
    

    

    //Mapeo para guardar tours
    @PostMapping("/tours/guardar")
    public String toursGuardar(Tours tours) {

        toursService.save(tours);
        //Esto es para que se vaya de nuevo al index
        return "redirect:/tours/modificar";

    }

    //Mapeo para actualizar tours
    @GetMapping("/tours/actualiza/{idTours}")
    public String toursActualiza(Tours tours, Model model) {

        tours = toursService.getTours(tours);
        model.addAttribute("tours", tours);
        return "/tours/modificar";

    }

    //Mapeo para eliminar tours
    @GetMapping("/tours/eliminar/{idTours}")
    public String toursElimina(Tours tours) {

        toursService.delete(tours);
        return "redirect:/tours/modificar";

    }

}
