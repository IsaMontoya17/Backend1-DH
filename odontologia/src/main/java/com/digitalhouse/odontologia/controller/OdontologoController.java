package com.digitalhouse.odontologia.controller;

import com.digitalhouse.odontologia.domain.Odontologo;
import com.digitalhouse.odontologia.services.impl.OdontologoService;
import com.digitalhouse.odontologia.services.IOdontologoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/odontologo")
public class OdontologoController {

    private IOdontologoService odontologoService;

    public OdontologoController() {
        this.odontologoService = new OdontologoService();
    }

    @GetMapping("/id")
    public String buscarOdontologoPorId(Model model, @RequestParam Integer id){
        Odontologo odontologo = odontologoService.buscarPorId(id);
        model.addAttribute("Nombre", odontologo.getNombre());
        model.addAttribute("Apellido", odontologo.getApellido());
        return "buscarOdontologo";
    }

}
