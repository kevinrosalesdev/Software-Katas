package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertarDatosTabla {
    
    private List<String> lista;

    public InsertarDatosTabla(List<String> lista) {
        this.lista = lista;
    }

    private Connection connect(){
        String url = "jdbc:sqlite:KATA5.db";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void insert(){
        String sql = "INSERT INTO EMAIL(Mail) VALUES(?)";
        try  (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
             for (String string : lista) {
                  pstmt.setString(1,string);
                  pstmt.executeUpdate();
             }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
   
}
