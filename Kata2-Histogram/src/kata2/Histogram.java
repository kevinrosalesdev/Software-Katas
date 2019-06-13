package kata2;

import java.util.HashMap;
import java.util.Map;

public class Histogram<T> {
    
    private final T [] data;

    public Histogram(T[] data) {
        this.data = data;
    }

    public T[] getData() {
        return data;
    }
    
    public Map getHistogram(){
        Map<T, Integer> histogram = new HashMap<>();
        for (T e : data) {
            histogram.put(e, histogram.containsKey(e) ? histogram.get(e) + 1 : 1);
        }
        return histogram;
    }
}
