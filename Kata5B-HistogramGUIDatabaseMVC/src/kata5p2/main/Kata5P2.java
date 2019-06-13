package kata5p2.main;

import java.util.List;
import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import kata5p2.view.HistogramDisplay;
import static kata5p2.view.MailHistogramBuilder.build;
import static kata5p2.view.MailListReaderBD.read;

public class Kata5P2 {
    
    private static List<Mail> mailList;
    private static Histogram<String> histogram;
    private static HistogramDisplay histoDisplay;
    
    public static void main(String[] args) {
        execute();
    }
    
    private static void execute(){
        input();
        process();
        output();
    }
    
    private static void input(){
        mailList = read();
    }
    
    private static void process(){
        histogram = build(mailList);
    }
    
    private static void output(){
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}