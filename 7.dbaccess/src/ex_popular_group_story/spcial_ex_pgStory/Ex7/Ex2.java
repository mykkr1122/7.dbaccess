package ex_popular_group_story.spcial_ex_pgStory.Ex7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex2 {        
    public static void main(String[] args) {
        String url="jdbc: postgresql://localhost5432/student";
        String user="postgres";
        String password="postgres";
    
        String sql="""
            insert into
            colors
            (id,name)
            values
            (1,'blue')
            ,(2,'red')
            ,(3,'green')
            ,(4,'yellow')
            ,(5,'purple')
            ,(6,'orange')
            ;
        """;
        
        try (Connection con=DriverManager.getConnection(url, user, password);
        PreparedStatement pstmt=con.prepareStatement(sql)) {
        try{   
            int numOfUpdate=pstmt.executeUpdate();
            System.out.println(numOfUpdate+"件のデータを操作しました");
        } catch (SQLException ex) {
            con.rollback();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }


    }
}
