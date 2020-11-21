public class Bicho {

    int salud = 10;
    String tipo = "BN";
    boolean vivo = true;

    public String toString(){
        String respuesta = "";

        if(this.salud <= 0){
            return "Murido";
        }

        return this.tipo + "-" + Integer.toString(this.salud);
    }

}