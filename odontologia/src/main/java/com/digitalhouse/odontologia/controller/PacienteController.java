package com.digitalhouse.odontologia.controller;

import com.digitalhouse.odontologia.services.impl.PacienteService;

public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }


}
