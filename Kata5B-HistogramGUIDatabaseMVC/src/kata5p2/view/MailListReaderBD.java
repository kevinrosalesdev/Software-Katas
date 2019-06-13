package kata5p2.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import kata5p2.model.Mail;

public class MailListReaderBD {
    
    public static List<Mail> read(){
        List<Mail> mailList = readFromTable();
        return mailList;
    }
    
    private static Connection connect(){
        String url = "jdbc:sqlite:KATA5.db";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    private static LinkedList<Mail> readFromTable(){
        LinkedList<Mail> res = new LinkedList<>();
        String sql = "SELECT * FROM EMAIL";
        try  (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
             while(rs.next()){
                 res.add(new Mail(rs.getString("Mail")));
             }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return res;
    }
}
