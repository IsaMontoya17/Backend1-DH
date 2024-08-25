package com.dh.Clase15_SpringMVC.dao.impl;

import com.dh.Clase15_SpringMVC.dao.IDAO;
import com.dh.Clase15_SpringMVC.modelo.Turno;

import java.util.ArrayList;
import java.util.List;

public class ImplementacionTurnoList implements IDAO<Turno> {

    List<Turno> turnoList = new ArrayList<>();

    @Override
    public Turno guardar(Turno turno) {
        //id lo vamos a cargar a mano
        turnoList.add(turno);
        return turno;
    }

    @Override
    public List<Turno> listarTodos() {
        return turnoList;
    }

    @Override
    public Turno consultarPorId(Integer id) {
        Turno turnoBuscado = null;

        for (Turno t: turnoList) {
            if(t.getId().equals(id)) {

                return t;
            }
         }

        return turnoBuscado;
    }

    @Override
    public void eliminarPorId(Integer id) {

    }

    @Override
    public Turno actualizar(Turno turno) {
        return null;
    }
}
