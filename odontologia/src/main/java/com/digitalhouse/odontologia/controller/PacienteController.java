package com.digitalhouse.odontologia.controller;

import com.digitalhouse.odontologia.domain.Odontologo;
import com.digitalhouse.odontologia.domain.Paciente;
import com.digitalhouse.odontologia.services.IPacienteService;
import com.digitalhouse.odontologia.services.impl.PacienteServiceImpl;
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
