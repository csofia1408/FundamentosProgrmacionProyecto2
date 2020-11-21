import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Principal{

    public static void main(String[] args) {
        Principal.mostrarMenu();
    }
    public static void mostrarMenu(){
        boolean a = true;

        while(a){

            Principal.limpiarConsola();
            Principal.mostrarTextoMenu();

            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            if(num == 0){
                Principal.limpiarConsola();

                System.out.println("Nos vemos ^^");
                break;
            }
            if(num == 1){
                Principal.limpiarConsola();

                System.out.println("------------ // Ingrese la informacón del vehiculo // ------------");
                System.out.println("¿Cual será el modelo? <INT>");
                int modelo = sc.nextInt();

                System.out.println("Ahora, ¿La marca? <STR>");
                String marca = sc.next();

                System.out.println("El valor comercial, porfa :) ");
                double valorComercial = sc.nextDouble();

                System.out.println("Por último, el color del vehiculo :D");
                String color = sc.next();

                Vehiculo.anadirVehiculo(modelo, marca, valorComercial, color);
                System.out.println("Vehiculo agrergado con exito :D");



            }

            if(num == 2){
                Principal.limpiarConsola();

                System.out.println(Vehiculo.toStringVehiculos());

                Principal.volverMenu();

            }
            /**
             * TODO: Más bonito:
             */
            if(num == 3){
                Principal.limpiarConsola();

                System.out.println("Haz añadido un total de: " + Vehiculo.cantidadVehiculos() + ", al momento.");

                Principal.volverMenu();
            }
            if(num == 4){

                Principal.limpiarConsola();


                ArrayList<Vehiculo> filtrarVehiculos = Vehiculo.filtrarVehiculos("verde");
                for (int i = 0; i < filtrarVehiculos.size(); i++) {
                    System.out.println(filtrarVehiculos.get(i).toString());
                }

                Principal.volverMenu();
            }
            if(num == 5){

                Principal.limpiarConsola();

                System.out.println("Por favor ingresa el id del vehiculo a consultar: ");
                int id = sc.nextInt();

                System.out.println(Vehiculo.getVehiculoById(id));

                Principal.volverMenu();

            }
            if(num == 6){

                Principal.limpiarConsola();

                System.out.println("Por favor ingresa el id al vehiculo a añadir sensor: ");
                int id = sc.nextInt();

                if(Vehiculo.ifVehiculoExistById(id) != null){

                    System.out.println("Ahora ingresa el tipo de sensor :D");
                    String tipo = sc.next();

                    System.out.println("Por último ingresa el valor del sensor ");
                    double valor = sc.nextDouble();

                    Vehiculo.anadirSensor(id, tipo, valor);

                }else{
                    System.out.println("No existe un vehiculo con ese id :/");
                }

            }
            if(num == 7){

                Principal.limpiarConsola();

                System.out.println("Por favor ingresa el id al vehiculo a añadir sensor: ");
                int id = sc.nextInt();
                System.out.println(Vehiculo.getSensoresByVehiculoId(id));

                Principal.volverMenu();

            }
            if(num == 8){
                ArrayList<Sensor>sensoresFiltrados = Sensor.filtrarSensores("temperatura");
                for (int i = 0; i < sensoresFiltrados.size(); i++) {
                    System.out.println(sensoresFiltrados.get(i).toString());
                }
            }

            if(num == 9){
                Principal.limpiarConsola();
                System.out.println(Vehiculo.getBiggerSensorsArray());
                Principal.volverMenu();
            }

            if(num == 666){
                ArrayList<Sensor> sensoresTemperatura = Sensor.filtrarSensores("temperatura");
                sensoresTemperatura = Sensor.ordenarMenorMayor(sensoresTemperatura);
                for (int i = 0; i < sensoresTemperatura.size(); i++) {
                    System.out.println(sensoresTemperatura.get(i).toString());
                }
            }

            if(num == 10){
                File file = new File("vehiculos.txt");

                try{
                    Scanner input = new Scanner(file);
                    String line;

                    while (input.hasNextLine()){
                        line = input.nextLine();
                        String[] parts = line.split(",");
                        Vehiculo.anadirVehiculo(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), parts[3]);
                    }
                }catch (Exception e){
                    System.out.println("Ocurrió un error :( ");
                    System.out.println(e);
                }

            }
        }
    }

    public  static void mostrarTextoMenu(){
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("\n" +
                " __  _                   _          __  _  __  __  __ \n" +
                "|_   |()                 | |        |  _|/ _ \\ |  _||_   ||   _|\n" +
                "  | |   _   _  _ _    _| |  _ _  | |_ / /\\ \\| |     | |    | |  \n" +
                "  | |  | | / _ \\| '_ \\  / ` | / _` | |  _||  _  ||  _|    | |    | |  \n" +
                "  | |  | ||  _/| | | || (| || (| | | |_| | | || |     _| |   | |  \n" +
                "  \\_/  || \\_||| || \\,| \\_,| \\__/\\_| |/\\|     \\__/   \\/  \n" +
                "                                                                        \n" +
                "                                                                        \n");

        System.out.println("------------ // Opciones // ------------");
        System.out.println("1. Crear un vehiculo :D. Haz añadido: " + (Vehiculo.vehiculos.size()) + " vehiculos en total.");
        System.out.println("2. Mostrar la información de los " + (Vehiculo.vehiculos.size()) + " vehiculos agregados al momento.");
        System.out.println("3. Mostrar la cantidad de vehiculos añadidos.");
        System.out.println("4. Mostrar información de los vehículos color verde.");
        System.out.println("5. Mostrar información de un vehiculo en en particular.");
        System.out.println("6. Añadir un sensor a un vehiculo.");
        System.out.println("7. Mostrar los sensores de un vehiculo.");
        System.out.println("8. Mostrar la información de los sensores tipo 'temperatura´.");
        System.out.println("9. Mostrar el vehiculo al cual más sensores le haz añadido.");
        System.out.println("10. Cargar vehiculos desde la base de datos de la NASA.");
        System.out.println("666. Mostrar los sensores tipo temperatura ordenados de menor a mayor.");
        System.out.println("0. Say good bay :(");

        System.out.println("------------ // - // ------------");
        System.out.println("Escriba el número correspondiente a la acción que desea realizar :D");
    }

    public static void limpiarConsola(){
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public static void volverMenu(){
        Scanner sc = new Scanner(System.in);

        int tecla;
        System.out.println("Ingresa 0 para volver al menú");
        tecla = sc.nextInt();

        while (tecla != 0){
            System.out.println("Lo siento, no reconocí la letra :/ ");
            System.out.println("Ingresa 0 para volver al menú");
            tecla = sc.nextInt();
        }
    }
}