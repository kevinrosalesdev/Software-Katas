package kata4.view;

import java.util.Iterator;
import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;

public class MailHistogramBuilder {
    public static Histogram<String> build (List<Mail> mailList){
        Histogram<String> histogram = new Histogram();
        Iterator<Mail> iter = mailList.iterator();
        while(iter.hasNext()){
            String dominio = ((Mail)iter.next()).getDomain();
            if (dominio != null){
                histogram.increment(dominio);
            }
        }
        return histogram;
    }
}
