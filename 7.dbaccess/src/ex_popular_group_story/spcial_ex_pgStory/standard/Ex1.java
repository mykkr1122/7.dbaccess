package ex_popular_group_story.spcial_ex_pgStory.standard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex1 {
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
                drop table
                if exists colors;

                create table colors
                (id integer primary key,
                    name text
                )
                ;

                drop table
                if exists members;

                create table members
                (id serial primary key,
                    name text not null,
                    birth_day date,
                    gender varchar(1),
                    color_id integer ,
 	                foreign key (color_id) references colors(id)
                )
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
