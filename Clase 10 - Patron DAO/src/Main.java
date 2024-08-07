import dao.BD;
import modelo.Medicamento;
import servicio.MedicamentoService;

public class Main {
    public static void main(String[] args) {
        MedicamentoService medicamentoService = new MedicamentoService();

        BD.createTable();

        Medicamento paracetamol = new Medicamento("Paracetamol",
                "Bayer", 11, 2500d, 11);

        Medicamento acetaminofen = new Medicamento("Acetaminofen",
                "Genfar", 5, 2000d, 34);

        medicamentoService.guardar(paracetamol);
        medicamentoService.guardar(acetaminofen);

        medicamentoService.buscarPorId(2);
        medicamentoService.buscarPorId(3);

        medicamentoService.listar();


    }
}
