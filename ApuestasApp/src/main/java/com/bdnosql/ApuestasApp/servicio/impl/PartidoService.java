package com.bdnosql.ApuestasApp.servicio.impl;

import com.bdnosql.ApuestasApp.modelo.Partido;
import com.bdnosql.ApuestasApp.repositorio.IPartidoRepositorio;
import com.bdnosql.ApuestasApp.servicio.IPartidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService implements IPartidoServicio {

    private IPartidoRepositorio partidoRepositorio;

    @Autowired
    public PartidoService(IPartidoRepositorio partidoRepositorio) {
        this.partidoRepositorio = partidoRepositorio;
    }

    @Override
    public Partido guardar(Partido partido) {
        return partidoRepositorio.save(partido);
    }

    @Override
    public List<Partido> listarTodos() {
        return partidoRepositorio.findAll();
    }
}
