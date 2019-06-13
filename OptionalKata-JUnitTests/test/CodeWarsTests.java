import codewars.Compare;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * CodeWarsTest: Serie de Test que comprueban el funcionamiento de Compare.
 * Sirven de referencia a la hora construir la clase.
 * 
 * @author Doramas Báez Bernal
 * @author Kevin Rosales Santana
 */
public class CodeWarsTests {
    
    private int[] v1;
    private int[] v2;
    private int[] v3;
    private int[] v4;
    private int[] v5;
    private int[] v6;
    private int[] v7;
    private int[] v8;
    private int[] v9;
    private int[] v10;
    
    @Before
    public void setUp() {
        v1 = new int[]{};
        v2 = new int[]{2};
        v3 = new int[]{4};
        v4 = new int[]{3,5};
        v5 = new int[]{9,25};
        v6 = new int[]{10,12,3};
        v7 = new int[]{144,9,100};
        v8 = new int[]{9,99,144};
        v9 = new int[]{-3,-9};
        v10 = new int[]{81,9};
    }
    
    @After
    public void tearDown() {
        v1 = null;
        v2 = null;
        v3 = null;
        v4 = null;
        v5 = null;
        v6 = null;
        v7 = null;
        v8 = null;
        v9 = null;
        v10 = null;
    }

    @Test
    public void test_length() {
        assertTrue("El mismo vector.", new Compare(v1,v1).vectorCompare());
        assertFalse("Vectores de tamaño distinto.", new Compare(v1,v2).vectorCompare());
        assertTrue("Vectores del mismo tamaño y datos correctos.", new Compare(v4,v5).vectorCompare());
        assertFalse("Vectores del mismo tamaño y datos incorrectos.", new Compare(v6,v8).vectorCompare());
    }
    
    @Test
    public void test_data(){
        assertTrue("Comprobación con vector correcto de tamaño 0.", new Compare(v1,new int[]{}).vectorCompare());
        assertTrue("Comprobación con vector correcto de tamaño 1.", new Compare(v2,v3).vectorCompare());
        assertTrue("Comprobación con vector correcto de tamaño 2.", new Compare(v4,v5).vectorCompare());
        assertTrue("Comprobación con vector correcto de tamaño 3 desordenado.", new Compare(v6,v7).vectorCompare());
        assertFalse("Comprobación con vector incorrecto de tamaño 3 desordenado.", new Compare(v6,v8).vectorCompare());
        assertTrue("Comprobación con vector correcto de tamaño 2 negativo desordenado.", new Compare(v9,v10).vectorCompare());
    }
}
