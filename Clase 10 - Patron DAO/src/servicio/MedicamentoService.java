package servicio;

import dao.IDao;
import dao.implementacion.MedicamentoDAOH2;
import modelo.Medicamento;

import java.util.List;

public class MedicamentoService {

    private IDao<Medicamento> medicamentoIDao;

    public MedicamentoService() {
        this.medicamentoIDao = new MedicamentoDAOH2();
    }

    public Medicamento guardar(Medicamento medicamento) {
        return medicamentoIDao.guardar(medicamento);
    }

    public Medicamento buscarPorId(Integer id) {
        return medicamentoIDao.buscarPorId(id);
    }

    public List<Medicamento> listar() {
        return medicamentoIDao.listar();
    }

}
