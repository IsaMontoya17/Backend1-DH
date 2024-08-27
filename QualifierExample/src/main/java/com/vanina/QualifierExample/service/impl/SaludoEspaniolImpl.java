package com.vanina.QualifierExample.service.impl;

import com.vanina.QualifierExample.service.ISaludoService;
import org.springframework.stereotype.Service;

@Service("SaludoEspaniolImpl")
public class SaludoEspaniolImpl implements ISaludoService {
    @Override
    public String saludo(String nombre) {
        return "Hola Mundo!";
    }
}
