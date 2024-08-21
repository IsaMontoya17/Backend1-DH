package com.digitalhouse.odontologiaAPIRest.services.impl;

import com.digitalhouse.odontologiaAPIRest.dao.IDAO;
import com.digitalhouse.odontologiaAPIRest.dao.impl.TurnoList;
import com.digitalhouse.odontologiaAPIRest.domain.Turno;
import com.digitalhouse.odontologiaAPIRest.services.ITurnoService;

import java.util.List;

public class TurnoServiceImpl implements ITurnoService {

    private IDAO<Turno> iDao;

    public TurnoServiceImpl () {
        this.iDao = new TurnoList();
    }

    @Override
    public Turno guardar(Turno turno) {
        return iDao.guardar(turno);
    }

    @Override
    public Turno buscarPorId(Integer id) {
        return iDao.consultarPorId(id);
    }

    @Override
    public List<Turno> listar() {
        return iDao.listar();
    }
}
