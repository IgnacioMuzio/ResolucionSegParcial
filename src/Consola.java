import java.util.Scanner;

public class Consola{
    private static Scanner tecla = new Scanner (System.in);

    public static void escribir (Object x) {
        System.out.println(x);
    }

    public static String leerString (String mensaje) {
        Consola.escribir(mensaje);
        return tecla.nextLine();
    }

    public static int leerInt (String mensaje) {
        Consola.escribir(mensaje);
        return tecla.nextInt();
    }

    public static float leerFloat (String mensaje) {
        Consola.escribir(mensaje);
        return tecla.nextFloat();
    }

    public static void limpiar(){
        tecla.nextLine();
    }
}
