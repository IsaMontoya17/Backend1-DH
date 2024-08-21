package com.digitalhouse.odontologiaAPIRest.services.impl;

import com.digitalhouse.odontologiaAPIRest.dao.IDAO;
import com.digitalhouse.odontologiaAPIRest.dao.impl.OdontologoDaoH2;
import com.digitalhouse.odontologiaAPIRest.domain.Odontologo;
import com.digitalhouse.odontologiaAPIRest.services.IOdontologoService;

import java.util.List;

public class OdontologoServiceImpl implements IOdontologoService {

    private IDAO<Odontologo> odontologoIDAO;

    public OdontologoServiceImpl() {
        odontologoIDAO = new OdontologoDaoH2();
    }

    public Odontologo guardar(Odontologo odontologo){
        return odontologoIDAO.guardar(odontologo);
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        return odontologoIDAO.consultarPorId(id);
    }

    @Override
    public Boolean eliminar(Integer id) { return odontologoIDAO.eliminarPorId(id); }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        return null;
    }

    public List<Odontologo> listar(){
        return odontologoIDAO.listar();
    }

}//CIERRE DE LA CLASE