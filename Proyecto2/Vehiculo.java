import java.util.ArrayList;
import java.util.Collections;

public class Vehiculo{
    //public static Vehiculo[] vehiculos = new Vehiculo[10];
    //public static int tamano = 10;
    //public static int posAnadir = 0;
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    public static int idActual = 1;
    private int id;
    private ArrayList<Sensor> sensores = new ArrayList<Sensor>();
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;

    public Vehiculo(){
        this.id = idActual;
        idActual = idActual +1;
        Vehiculo.vehiculos.add(this);

    }

    public Vehiculo(int mo,String ma,double va){
        this(mo,ma,va,"verde");
    }

    public Vehiculo(int mo,String ma,double va,String co){
        this.modelo = mo;
        this.marca = ma;
        this.valorComercial = va;
        this.color = co;

        this.id = idActual;
        idActual = idActual +1;
        Vehiculo.vehiculos.add(this);

    }
    public ArrayList<Sensor> getsensores(){
        return this.sensores;
    }

    public int getid(){
        return this.id;
    }

    public int getmodelo(){
        return this.modelo;
    }

    public String getmarca(){
        return this.marca;
    }

    public double getvalorComercial(){
        return this.valorComercial;
    }

    public String getcolor(){
        return this.color;
    }

    public void setid(int id){
        this.id = id;
    }
    public void setsensores(ArrayList<Sensor> sensores){
        this.sensores = sensores;
    }
    public void setmodelo(int mo){
        this.modelo = mo;
    }

    public void setmarca(String ma){
        this.marca = ma;
    }

    public void setvalorComercial(double va){
        this.valorComercial = va;
    }

    public void setcolor(String co){
        this.color = co;
    }

    public static String toStringVehiculos(){
        String texto = "";

        if(Vehiculo.vehiculos.isEmpty()){
            texto = "No hay vehiculos agregados :c";
        }else{
            for(int i = 0; i < Vehiculo.vehiculos.size(); i++){
                texto += vehiculos.get(i).toString() + "\n";
                texto += "----- // -----" + "\n";
            }
        }

        return texto;
    }

    public static int cantidadVehiculos(){
        return Vehiculo.vehiculos.size();
    }

    public String toString(){

        String texto = "Este auto es de modelo: " + this.modelo +", con un id: "+ this.id +", de la marca: " +  this.marca +  ", de color: " + this.color + ", con un valor comercial de: $" + this.valorComercial + "\n";

        System.out.println(this.sensores.size());
        if(this.sensores.isEmpty()){
            texto += "No contiene ningún sensor hasta el momento.";
        }else{
            for(int i=0; i < this.sensores.size();i++){

                texto += this.sensores.get(i).toString();

            }
        }
        return texto;
    }

    public static ArrayList<Vehiculo> filtrarVehiculos(String tipoAFiltrar){

        ArrayList<Vehiculo> vehiculosFiltrados = new ArrayList<>();

        for(int i = 0; i < Vehiculo.vehiculos.size(); i++){

            if((Vehiculo.vehiculos.get(i).getcolor()).equals(tipoAFiltrar)){
                vehiculosFiltrados.add(Vehiculo.vehiculos.get(i));
            }

        }

        return vehiculosFiltrados;

    }

    public static void anadirVehiculo(int modelo, String marca, double valor, String color){
        new Vehiculo(modelo, marca, valor, color);
    }

    public static void anadirSensor (int id, String tipo, double valor){

        Sensor s = new Sensor(tipo, valor);
        Vehiculo v = Vehiculo.ifVehiculoExistById(id);
        v.sensores.add(s);

    }

    public static String getVehiculoById(int id){

        if(Vehiculo.ifVehiculoExistById(id) != null){
            return Vehiculo.vehiculos.get(id).toString();
        }

        return "No se encontró un vehiculo con el id: " + id +  " :/, intenta con otro :D";
    }

    public static Vehiculo ifVehiculoExistById(int id){
        for (int i = 0; i < Vehiculo.vehiculos.size(); i++) {
            if(Vehiculo.vehiculos.get(i).id == id){
                return Vehiculo.vehiculos.get(i);
            }
        }

        return null;
    }

    public int cantidadSensores(){

        return this.sensores.size();

    }

    public static String getSensoresByVehiculoId(int id){

        Vehiculo v  =  Vehiculo.ifVehiculoExistById(id);

        String text = "";
        if(v != null){
            for (int i = 0; i < v.sensores.size(); i++) {
                text += v.sensores.get(i).toString() + "\n";
            }
        }else{
            text += "No existe un vehiculo con este id >:(";
        }

        return text;

    }

    public static String getBiggerSensorsArray(){

        String texto = "";

        if(Vehiculo.vehiculos.isEmpty()){
            texto = "No hay vehiculos :(";
        }else{
            Vehiculo masGrande = Vehiculo.vehiculos.get(0);

            for (Vehiculo vehiculo: Vehiculo.vehiculos) {
                if (masGrande.sensores.size() < vehiculo.sensores.size()){
                    masGrande = vehiculo;
                }
            }

            return masGrande.toString();

        }

        return texto;
    }
}