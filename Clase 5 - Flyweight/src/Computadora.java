public class Computadora {
    private Integer ram;
    private Integer discoDuro;
    private String modelo;
    //agregamos este atributo para poder contar la cantidad de instancias de este objeto
    private static Integer contador = 0; //el contador arranca en cero

    public Computadora(Integer ram, Integer discoDuro, String modelo) {
        this.ram = ram;
        this.discoDuro = discoDuro;
        this.modelo = modelo;
        //cada vez que se crea una computadora -> el contador se incrementa en 1
        contador++;
        System.out.println("El valor del constructor es: " + contador);
    }

    public static Integer get(Integer contador) {
        return  contador;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public void setDiscoDuro(Integer discoDuro) {
        this.discoDuro = discoDuro;
    }

}

