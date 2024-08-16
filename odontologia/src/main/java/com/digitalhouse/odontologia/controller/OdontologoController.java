package com.digitalhouse.odontologia.controller;

import com.digitalhouse.odontologia.domain.Odontologo;
import com.digitalhouse.odontologia.services.impl.OdontologoServiceImpl;
import com.digitalhouse.odontologia.services.IOdontologoService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/odontologo")
public class OdontologoController {

    private IOdontologoService iOdontologoServiceImpl;

    public OdontologoController() {

        this.iOdontologoServiceImpl = new OdontologoServiceImpl();
    }

    @GetMapping("/id")
    public String buscarOdontologoPorId(Model model, @RequestParam Integer id){

        Odontologo odontologo = iOdontologoServiceImpl.buscarPorId(id);

        if (odontologo == null) {
            model.addAttribute("error", "Odontólogo no encontrado");
            return "errorPage";
        }

        model.addAttribute("Nombre", odontologo.getNombre());
        model.addAttribute("Apellido", odontologo.getApellido());
        return "buscarOdontologo";
    }

}
