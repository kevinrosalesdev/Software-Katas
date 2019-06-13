package codewars;

/**
 * Clase Compare: Compara dos arrays. 
 * El cometido principal es la comprobación de que todos los elementos al 
 * cuadrado de v1 se pueden encontrar al cuadrado en v2 en una relación 1 a 1 
 * (Ambos arrays deben tener la misma longitud).
 * 
 * Se asume que al usuario final le es indiferente cómo queden ambos vectores
 * y que pueden ser modificados, dando más importancia a la eficiencia.
 * 
 * Además, se pidió expresamente que no se importara ninguna librería que pudiera
 * ayudar a realizar la actividad.
 * 
 * @author Doramas Báez Bernal
 * @author Kevin Rosales Santana
 */
public class Compare {
    private final int [] v1;
    private final int [] v2;
    

    public Compare(int[] v1, int[] v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    /**
     * vectorCompare(): Compara si todos los elementos de v1 encuentran su
     * cuadrado respectivo en v2.
     * 
     * @return true si lo encuentra, false si no encuentra alguno. 
     */
    public boolean vectorCompare() {
        if (v1.length != v2.length) return false;
        for (int i = 0; i < v1.length; i++) {
            if (! isSquare(v1[i]) ) {
                return false;
            }
        }
        return true;
    }

    public int[] getS1() {
        return v1;
    }

    public int[] getS2() {
        return v2;
    }
    
    /**
     * isSquare(int number): Compara si un elemento pasado por parámetro encuentra
     * su cuadrado en v2. Si es así, marca el elemento correspondiente con -1 para
     * que ningún otro vuelva a compararse con éste.
     * 
     * @param number Número a comparar en v2.
     * @return true si lo encuentra, false si no es así.
     */
    public boolean isSquare(int number) {
        for (int i = 0; i < v2.length; i++) {
            if ((v2[i] != -1) && (number*number) == v2[i]) {
                //System.out.println("Se ha encontrado el cuadrado de " + number + 
                //                   " que se corresponde con " + v2[i]);
                v2[i] = -1;
                return true;
            }
        }
        //System.out.println("No se ha podido encontrar el cuadrado de " + number);
        return false;
    }
}
