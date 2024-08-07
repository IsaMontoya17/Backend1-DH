package dao;

public interface IDao<T> {
    //CRUD

    //CREATE -> PERSISTIR
    T guardar(T t);
    T buscarPorId(Integer id);
}
