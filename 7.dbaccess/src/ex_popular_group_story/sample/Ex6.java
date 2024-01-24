package ex_popular_group_story.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex6 {
    public static void main(String[] args) {
         String url="jdbc:postgresql://localhost:5432/student";
        String user="postgres";
        String passwword="postgres";

        Connection con=null;
        PreparedStatement pstmt=null;
        String sql=null;

        try {
            con=DriverManager.getConnection(url, user, passwword);

            sql="""
                drop
                table
                members
                ;
            """;
            
            pstmt=con.prepareStatement(sql);

            int numOfUpdate=pstmt.executeUpdate();
            System.out.println(numOfUpdate+"件のデータを操作しました");
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
