package com.digitalhouse.odontologia.services.impl;

import com.digitalhouse.odontologia.dao.IDAO;
import com.digitalhouse.odontologia.dao.impl.OdontologoDaoH2;
import com.digitalhouse.odontologia.domain.Odontologo;
import com.digitalhouse.odontologia.services.IOdontologoService;

import java.util.List;

public class OdontologoService implements IOdontologoService {

    private IDAO<Odontologo> interfazDao;

    public OdontologoService() {
        interfazDao = new OdontologoDaoH2();
    }

    public Odontologo guardar(Odontologo odontologo){
        return interfazDao.guardar(odontologo);
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    public List<Odontologo> listar(){
        return interfazDao.listar();
    }
}