import java.util.Random;
import java.util.Scanner;
public class Tablero {
        public static int seleccionNumeroAleatorio(int max,int min){
        Random r = new Random();
        int numBichos = r.nextInt((max - min) + min) + min;
        int count = 0;
        return numBichos;
    }
    
    public static Bicho[][] distribucionBichosTablero(int numBichos){
        Scanner sc = new Scanner(System.in);
        Bicho[][] tablero = new Bicho[2][2];
        Random r = new Random();
        int count = 0;
        
        for (int j = 0; j < tablero.length; j++) {
            for (int k = 0; k < tablero[j].length; k++) {
                
                int type = r.nextInt((2- 1) + 1) + 1;
                
                if(type == 0){
                    tablero[j][k]= new Bicho();
                }else{
                    tablero[j][k] = new BichoAlien();
                }

                count ++;
                if(count == numBichos) {
                    break;
                }
            }

            if(count == numBichos) {
                break;
            }
        }
        return tablero;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Bicho[][] tablero = new Bicho[2][2];
        Jugador j1 = new Jugador();
        
        int numBichos = Tablero.seleccionNumeroAleatorio(4,1);
        tablero = Tablero.distribucionBichosTablero(numBichos);
        Tablero.MostrarTablero(tablero,numBichos);


        int x;
        int y;

        while (true){
            System.out.println("Ingrese la cordenada x:");
            x = sc.nextInt();
            System.out.println("Ingrese la cordenada y:");
            y = sc.nextInt();

            try {
                tablero[x][y].salud -= j1.ataque;
                if (tablero[x][y].salud <= 0){
                    j1.kills += 1;
                }
            }catch (Exception e){
                System.out.println("¡No hay un alien en esa coordenada!");
            }

            if(j1.kills == numBichos){
                System.out.println("" +
                        "\n" +
                        " _     _ __   _    _    _          _ ___  _   _ \n" +
                        " \\ \\   / // _ \\ | |  | |   \\ \\        / /|   _|| \\ | |\n" +
                        "  \\ \\_/ /| |  | || |  | |    \\ \\  /\\  / /   | |  |  \\| |\n" +
                        "   \\   / | |  | || |  | |     \\ \\/  \\/ /    | |  | . ` |\n" +
                        "    | |  | |_| || || |      \\  /\\  /    _| | | |\\  |\n" +
                        "    ||   \\_/  \\__/        \\/  \\/    |__||| \\_|\n" +
                        "                                                        \n" +
                        "                                                        \n");
                break;
            }

            Tablero.MostrarTablero(tablero, numBichos);

        }
    }


    public static void MostrarTablero(Bicho[][] tablero, int numBichos){

        for (int i = 0; i < 50; ++i) System.out.println();

        int aux = 0;
        for (int j = 0; j < tablero.length; j++){
            System.out.println("--------------");
            for (int k = 0; k < tablero[j].length; k++){
                aux++;
                if(aux > numBichos){
                    if(aux % 2 == 0){
                        System.out.println(" - " + " | ");
                    }else{
                        System.out.print(" - " + " | ");
                    }
                }else{
                    if(aux % 2 == 0){
                        System.out.println(tablero[j][k].toString() + " | ");
                    }else{
                        System.out.print(tablero[j][k].toString() + " | ");
                    }
                }
            }
            System.out.println("--------------");
        }
    }

}
