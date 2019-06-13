package kata6;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Kata6 {
    /**
     * Versión 2: Mejora recursiva de la Kata. Ahora los iteradores recorrerán un array
     * de todas las carpetas recursivamente y se calculará el tamaño de éstas para ponerlas
     * en el mapa.
     * 
     * Nota: Evidentemente, el tiempo que tarda en hacerlo desde "/" es considerable.
     * (Alrededor de 2 minutos en mi PC)
     * 
     * 
     * @param args 
     */
    public static void main(String[] args) {
        //Write your directory
        File root = new File("..");
        List<File> listaFinal = new LinkedList<>();
        listaRecursiva(listaFinal, root);
        File[] files = new File[listaFinal.size()];
        files = listaFinal.toArray(files);
        for (File file : files) {
            System.out.println(file);
        }
        Histogram histo = new Histogram<>(megabytes(lengths(iteratorOf(files))));
        System.out.println("El resultado es " + histo.getMap().entrySet());
    }
    
    private static void listaRecursiva(List<File> listaFinal, File carpeta){
        File[] files = carpeta.listFiles();
        if (files != null){
            for (File file : files) {
                listaFinal.add(file);
                listaRecursiva(listaFinal,file);
            }
        }
    }

    private static <X> Iterator<X> iteratorOf(X[] items) {
        return new Iterator<X>(){
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < items.length;
            }

            @Override
            public X next() {
                return items[index++];
            }
        };
    }

    private static Iterator<Long> lengths(Iterator<File> iterator) {
        return new Iterator<Long>(){
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Long next() {
                return iterator.next().length();
            }
        };
    }

    private static Iterator<Integer> megabytes(Iterator<Long> iterator) {
        return new Iterator<Integer>(){
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return (int) (iterator.next() / (1024*1024));
            }
        };
    }

}
