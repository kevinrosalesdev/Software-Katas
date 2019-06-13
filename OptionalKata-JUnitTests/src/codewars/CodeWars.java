package codewars;

/**
 * Clase CodeWars: Realiza una serie de llamadas a métodos de Compare
 * para comprobar de una manera sencilla su funcionamiento.
 * 
 * Para arrancar las pruebas de JUnit basta con hacer "Run File" en
 * el fichero CodeWarsTests.java (Dentro de la Carpeta test).
 * 
 * @author Doramas Báez Bernal
 * @author Kevin Rosales Santana
 */
public class CodeWars {

    public static void main(String[] args) {
        int [] v1  = {121,144,19,161,19,144,19,11}; 
        int [] v2  = {121,14641,20736,361,25921,361,20736,361}; 
        Compare aux = new Compare(v1,v2);
        
        if (aux.vectorCompare()) {
            System.out.println("Se han encontrado todos los elementos.");
        }else
            System.out.println("No se han podido encontrar todos los elementos esperados.");
        
        int [] res = aux.getS2();
        System.out.println("El resultado final del 2º vector es:");
        System.out.print("[ ");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println("]");
    }
}
