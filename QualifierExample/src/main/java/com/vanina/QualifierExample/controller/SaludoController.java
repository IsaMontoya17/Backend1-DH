package com.vanina.QualifierExample.controller;

import com.vanina.QualifierExample.service.ISaludoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @Autowired
    @Qualifier("SaludoInglesImpl")
    private ISaludoService serviceIngles;

    @Autowired
    @Qualifier("SaludoEspaniolImpl")
    private ISaludoService serviceEspañol;

    @GetMapping("/ingles")
    public String saludoIngles(String nombre) {
        return serviceIngles.saludo(nombre);
    }
    @GetMapping("/espaniol")
    public String saludoEspañol(String nombre) {
        return serviceEspañol.saludo(nombre);
    }
}
