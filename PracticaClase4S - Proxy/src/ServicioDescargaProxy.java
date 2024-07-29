public class ServicioDescargaProxy implements IServicioDescarga{

    private ServicioDescarga servicioDescarga;

    public ServicioDescargaProxy() {
        this.servicioDescarga =  new ServicioDescarga();
    }

    @Override
    public String descargar(String cancion, Usuario usuario) {

        if(usuario.getTipoUsuario() == TipoUsuario.PREMIUM){
            return servicioDescarga.descargar(cancion, usuario);
        }else{
            System.out.println("El usuario con id " + usuario.getId() + " no puede descargar canciones ");
            return "El usuario con id " + usuario.getId() + " no puede descargar canciones ";
        }
    }
}
