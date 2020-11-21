import java.util.ArrayList;

public class Sensor {

    public static Sensor[] sensores = new Sensor[8];
    public int tamano = 8;
    public static int posAnadir = 0;
    private String tipo;
    private double valor;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public 
    Sensor(){
        Sensor.sensores[Sensor.posAnadir] = this;
        Sensor.posAnadir = posAnadir+1;
    }

    Sensor(String t, double v){
        this.tipo = t;
        this.valor = v;
        Sensor.sensores[Sensor.posAnadir] = this;
        Sensor.posAnadir = Sensor.posAnadir+1;
    }

    public String toString(){
        return "Este sensor es de tipo: " + this.tipo + " y tiene un valor de: " + this.valor +"\n";
    }

    public static String toStringSensores(){

        String answer = "";

        for (int i = 0; i < posAnadir; i++) {
            answer = Sensor.sensores[i].toString();
        }

        /**
         * Se pone debido a que el IDE retorna error
         * 'Missing return'
         */
        return  answer;

    }

    public static ArrayList<Sensor> filtrarSensores(String tipoAFiltrar){

        ArrayList<Sensor> sensoresTemperatura = new ArrayList<Sensor>();

        for(int i = 0; i < Sensor.posAnadir; i++){
            if((Sensor.sensores[i].getTipo()).equals(tipoAFiltrar)){
                sensoresTemperatura.add(Sensor.sensores[i]);
            }
        }

        return sensoresTemperatura;

    }

    public static ArrayList<Sensor> ordenarMenorMayor(ArrayList<Sensor> sensoresTemperatura){

        Sensor val;
        int n = sensoresTemperatura.size();
        for(int i=1; i<n; i++) {
            for(int j=0; j<n-i; j++){
                if(sensoresTemperatura.get(j).getValor()>sensoresTemperatura.get(j+1).getValor() ) {
                    val = sensoresTemperatura.get(j);
                    sensoresTemperatura.set(j,sensoresTemperatura.get(j+1)) ;
                    sensoresTemperatura.set(j+1,val);
                }
            }
        }

        return sensoresTemperatura;

    }

    public static void anadirSensor(String tipo, double valor){
        new Sensor(tipo,valor);
    }
    public static int cantidadSensores(){
        return posAnadir;
    }

    
}