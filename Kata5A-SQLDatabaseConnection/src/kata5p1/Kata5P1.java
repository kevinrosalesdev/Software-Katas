package kata5p1;

import java.util.List;
//import static kata5p1.CrearTabla.createNewTable;
import static kata5p1.MailListReader.read;

public class Kata5P1 {

    public static void main(String[] args) {
        //Seleccionamos todos los registros de la Base de Datos.
        //SelectApp app = new SelectApp();
        //app.selectAll();
        
        //Añadimos una tabla con las características deseadas en la Versión 2.
        //createNewTable();
        
        String ruta = "email.txt";
        List<String> lista = read(ruta);
        InsertarDatosTabla idt = new InsertarDatosTabla(lista);
        idt.insert();
    }
    
}
