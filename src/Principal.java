import java.util.Map;
import java.util.Scanner;

public class Principal {

    public String base_code;  // La moneda base, por ejemplo, USD
    public Map<String, Double> conversion_rates;

    public static void main(String[] args) {
        ConsultarMoneda consultarMoneda = new ConsultarMoneda();
        while (true){
            System.out.println("""
                *************************************
                Bienvenido al convertidor de moneda
                
                1) Dolar =>> Peso Argentino
                2) Peso Argentino =>> Dolar
                3) Dolar =>> Real brasileño
                4) Real brasileño =>> Dolar
                5) Dolar =>> Peso colombiano
                6) Peso colombiano =>> Dolar
                7) Salir 
                Elija una opcion valida:
                *************************************
                """);
            Scanner Lector = new Scanner(System.in);
            int Opcion = Lector.nextInt();

            if (Opcion == 1) {
                System.out.println("Ingrese la cantidad a convertir: ");
                double valor = Lector.nextDouble();
                String resultado = consultarMoneda.buscarMoneda("USD", "ARS", valor);
                System.out.println(resultado);

            } else if (Opcion==2) {
                System.out.println("Ingrese la cantidad a convertir: ");
                double valor = Lector.nextDouble();
                String resultado = consultarMoneda.buscarMoneda("ARS", "USD", valor);
                System.out.println(resultado);

            } else if (Opcion==3) {
                System.out.println("Ingrese la cantidad a convertir: ");
                double valor = Lector.nextDouble();
                String resultado = consultarMoneda.buscarMoneda("USD", "BRL", valor);
                System.out.println(resultado);
            } else if (Opcion==4) {
                System.out.println("Ingrese la cantidad a convertir: ");
                double valor = Lector.nextDouble();
                String resultado = consultarMoneda.buscarMoneda("BRL", "USD", valor);
                System.out.println(resultado);
            } else if (Opcion==5) {
                System.out.println("Ingrese la cantidad a convertir: ");
                double valor = Lector.nextDouble();
                String resultado = consultarMoneda.buscarMoneda("USD", "COP", valor);
                System.out.println(resultado);
            } else if (Opcion==6) {
                System.out.println("Ingrese la cantidad a convertir: ");
                double valor = Lector.nextDouble();
                String resultado = consultarMoneda.buscarMoneda("COP", "USD", valor);
                System.out.println(resultado);
            }else if (Opcion==7){
                System.out.println("Saliendo del sistema");
                break;
            }else {
                System.out.println("Ingrese valor valido");
            }
        }
    }
}
