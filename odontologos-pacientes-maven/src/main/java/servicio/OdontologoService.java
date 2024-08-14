package servicio;

import dao.IDAO;
import dao.impl.OdontologoDaoH2;
import modelo.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDAO<Odontologo> interfazDao;

    public OdontologoService() {
        interfazDao = new OdontologoDaoH2();
    }

    public Odontologo guardar(Odontologo odontologo){
        return interfazDao.guardar(odontologo);
    }

    public List<Odontologo> listar(){
        return interfazDao.listar();
    }
}