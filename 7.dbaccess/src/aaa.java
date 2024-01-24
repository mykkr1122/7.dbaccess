import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class aaa {
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/miyakikaoru";
        String user="postgres";
        String passwword="postgres";

        ResultSet rs=null;
        Connection con=null;
        PreparedStatement pstmt=null;
        String sql=null;

        try {
            con=DriverManager.getConnection(url, user, passwword);

            sql="""
                select *
                from colors
            """;
            
            pstmt=con.prepareStatement(sql);

            rs=pstmt.executeQuery();
            while(rs.next()){                                  
                int id=rs.getInt("id");            
                String name=rs.getString("name");


                System.out.println("id="+id);
                System.out.println("name="+name);
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println("SQL="+sql);
            ex.printStackTrace();
        }finally{

            try {
                if (con !=null) {
                    con.close();
                }
                if (pstmt !=null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
       
    }
}
