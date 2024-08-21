package com.digitalhouse.odontologiaAPIRest.controller;

import com.digitalhouse.odontologiaAPIRest.domain.Paciente;
import com.digitalhouse.odontologiaAPIRest.services.IPacienteService;
import com.digitalhouse.odontologiaAPIRest.services.impl.PacienteServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class PacienteController {

    private IPacienteService iPacienteServiceImpl;

    public PacienteController() {
        this.iPacienteServiceImpl = new PacienteServiceImpl();
    }

    @GetMapping("/id")
    public String buscarPacientePorId(Model model, @RequestParam Integer id){
        Paciente paciente = iPacienteServiceImpl.buscarPorId(id);
        model.addAttribute("Nombre", paciente.getNombre());
        model.addAttribute("Apellido", paciente.getApellido());
        return "buscarPaciente";
    }

}
