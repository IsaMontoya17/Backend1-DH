package com.dh.odontologiaEjemplo.controller;

import com.dh.odontologiaEjemplo.domain.Odontologo;
import com.dh.odontologiaEjemplo.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("odontologos")
public class OdontologoController {


    private final OdontologoService odontologoService;


    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }


    @GetMapping
    public List<Odontologo> getOdontologos() {
        return odontologoService.listaOdontologos();
    }
}

