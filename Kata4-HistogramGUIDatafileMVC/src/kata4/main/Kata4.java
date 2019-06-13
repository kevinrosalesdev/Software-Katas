package kata4.main;

import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import static kata4.view.MailHistogramBuilder.build;
import static kata4.view.MailListReader.read;

public class Kata4 {
    
    private static String filename;
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
        filename = "email.txt";
        mailList = read(filename);
    }
    
    private static void process(){
        histogram = build(mailList);
    }
    
    private static void output(){
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}