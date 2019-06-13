package kata5p1;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class MailListReader {
    public static List<String> read (String fileName){
        String fichero = fileName;
        List<String> mailList = new LinkedList<>();
        try{
            try (FileReader fr = new FileReader(fichero)) {
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null){
                    if(linea.contains("@")){
                        mailList.add(linea);
                    }
                }
            }
        }catch (IOException e){
            System.out.println("Excepción leyendo el fichero " + fileName + ": " + e);
        }
        return mailList;
    }
}