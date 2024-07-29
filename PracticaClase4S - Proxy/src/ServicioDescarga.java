public class ServicioDescarga implements IServicioDescarga{
    @Override
    public String descargar(String cancion, Usuario usuario) {
        System.out.println("El usuario con id " + usuario.getId() + " descargo exitosamente la cancion " + cancion);
        return "El usuario con id " + usuario.getId() + " descargo exitosamente la cancion " + cancion;
    }
}
