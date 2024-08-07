package servicio;

import dao.IDao;
import dao.implementacion.MedicamentoDAOH2;
import modelo.Medicamento;

//acá va a estar la lógica de negocio
public class MedicamentoService {

    private IDao<Medicamento> medicamentoIDao;

    public MedicamentoService() {
        this.medicamentoIDao = new MedicamentoDAOH2();
    }

    //lógica del método guardar
    public Medicamento guardar(Medicamento medicamento) {
        return medicamentoIDao.guardar(medicamento);
    }

}
