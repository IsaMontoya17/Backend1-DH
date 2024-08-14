package servicio;

import dao.IDAO;
import dao.impl.PacienteDaoH2;
import modelo.Paciente;

import java.util.List;

public class PacienteService {
    private IDAO<Paciente> interfazDAO;

    public PacienteService() {
        this.interfazDAO = new PacienteDaoH2();
    }

    public Paciente guardar(Paciente paciente) {
        return interfazDAO.guardar(paciente);
    }

    public void eliminar(Integer id){
        interfazDAO.eliminarPorId(id);
    }

    public List<Paciente> listarTodos() {
        return interfazDAO.listar();
    }

    public Paciente buscarPorId(Integer id) {
        return interfazDAO.consultarPorId(id);
    }

    public Paciente actualizar(Paciente paciente) {
        return interfazDAO.actualizar(paciente);
    }

}
