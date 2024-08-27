package com.vanina.QualifierExample.service.impl;

import com.vanina.QualifierExample.service.ISaludoService;
import org.springframework.stereotype.Service;

@Service("SaludoInglesImpl")
public class SaludoInglesImpl implements ISaludoService {
    @Override
    public String saludo(String nombre) {
        return "Hello World";
    }
}
