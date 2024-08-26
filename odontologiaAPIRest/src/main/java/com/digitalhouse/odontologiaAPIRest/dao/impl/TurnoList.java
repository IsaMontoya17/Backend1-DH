package com.digitalhouse.odontologiaAPIRest.dao.impl;

import com.digitalhouse.odontologiaAPIRest.dao.IDAO;
import com.digitalhouse.odontologiaAPIRest.domain.Turno;

import java.util.ArrayList;
import java.util.List;

public class TurnoList implements IDAO<Turno> {

    List<Turno> turnoList = new ArrayList<>();

    @Override
    public Turno guardar(Turno turno) {
        turnoList.add(turno);
        return turno;
    }

    @Override
    public List<Turno> listar() {
        return turnoList;
    }

    @Override
    public Turno consultarPorId(Integer id) {
        Turno turnoBuscado = null;

        for (Turno t: turnoList) {
            System.out.println(t.getId() + " " + id);
            if(t.getId().equals(id)) {
                return t;
            }
        }
        return turnoBuscado;
    }

    @Override
    public Boolean eliminarPorId(Integer id) {
        for (Turno t : turnoList) {
            if (t.getId().equals(id)) {
                turnoList.remove(t);
                return true;
            }
        }
        return false;
    }


    @Override
    public Turno actualizar(Turno turno) {
        return null;
    }
}
