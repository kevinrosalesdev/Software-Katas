package kata2;

import java.util.Map;

public class Kata2 {

    public static void main(String[] args) {
        String[] data = {"Gabriel", "Gabriel", "Alfonso", "Pepe", "Rosa", "Alfonso", "Gabriel", "Pepe", "María", "Rosa"};
        Histogram histo = new Histogram(data);
        Map<String,Integer> histogr = histo.getHistogram();
        for (Map.Entry<String,Integer> entry : histogr.entrySet()){
            System.out.println(entry.getKey() + " ==> " + entry.getValue());
        }
    }    
}
