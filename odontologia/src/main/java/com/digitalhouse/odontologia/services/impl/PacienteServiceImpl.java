package com.digitalhouse.odontologia.services.impl;

import com.digitalhouse.odontologia.dao.IDAO;
import com.digitalhouse.odontologia.dao.impl.PacienteDaoH2;
import com.digitalhouse.odontologia.domain.Paciente;
import com.digitalhouse.odontologia.services.IPacienteService;

import java.util.List;

public class PacienteServiceImpl implements IPacienteService {
    private IDAO<Paciente> interfazDAO;

    public PacienteServiceImpl() {
        this.interfazDAO = new PacienteDaoH2();
    }

    public Paciente guardar(Paciente paciente) {
        return interfazDAO.guardar(paciente);
    }

    public void eliminar(Integer id){
        interfazDAO.eliminarPorId(id);
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

}
