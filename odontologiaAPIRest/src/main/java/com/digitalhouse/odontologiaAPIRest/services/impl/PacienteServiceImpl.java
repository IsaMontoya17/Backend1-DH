package com.digitalhouse.odontologiaAPIRest.services.impl;

import com.digitalhouse.odontologiaAPIRest.dao.IDAO;
import com.digitalhouse.odontologiaAPIRest.dao.impl.PacienteDaoH2;
import com.digitalhouse.odontologiaAPIRest.domain.Paciente;
import com.digitalhouse.odontologiaAPIRest.services.IPacienteService;

import java.util.List;

public class PacienteServiceImpl implements IPacienteService {
    private IDAO<Paciente> interfazDAO;

    public PacienteServiceImpl() {
        this.interfazDAO = new PacienteDaoH2();
    }

    public Paciente guardar(Paciente paciente) { return interfazDAO.guardar(paciente); }

    public Boolean eliminar(Integer id){
         return interfazDAO.eliminarPorId(id);
    }

    public List<Paciente> listar() {
        return interfazDAO.listar();
    }

    public Paciente buscarPorId(Integer id) {
        return interfazDAO.consultarPorId(id);
    }

    public Paciente actualizar(Paciente paciente) {
        return interfazDAO.actualizar(paciente);
    }

}//CIERRE DE LA CLASE
