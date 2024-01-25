package ex_popular_group_story.spcial_ex_pgStory.Ex7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex1 {
    public static void main(String[] args) {
    String url="jdbc:postgresql://localhost:5432/student";
    String user="postgres";
    String password="postgres";

    Connection con=null;
        PreparedStatement pstmt1=null;
        PreparedStatement pstmt2=null;
        String sql1=null;
        String sql2=null;
        

    // String sql1="""
    //             begin;
    //             drop table
    //             if exists new_colors;

    //             create table new_colors
    //             (id integer primary key,
    //                 name text
    //             )
    //             ;
    //     """;

    // String sql2="""
    //             drop table 
    //             if exists new_members;
                
    //             create table new_members
    //             (id serial primary key,
    //             name text not null,
    //             birth_day date,
    //             gender varchar(1),
    //             color_id integer ,
    //             foreign key (color_id) references colors(id) 
    //             )
    //             ; 
    //     """;

    // try (Connection con=DriverManager.getConnection(url, user, password)) {
        // con.setAutoCommit(false);
        // try(PreparedStatement pstmt1=con.prepareStatement(sql1);
        //     PreparedStatement pstmt2=con.prepareStatement(sql2)){   
        //     int numOfUpdate1=pstmt1.executeUpdate();
        //     System.out.println(numOfUpdate1+"件(1件目)のデータを操作しました");

            
        //     int numOfUpdate2= pstmt2.executeUpdate();
        //     con.commit();
        //     System.out.println(numOfUpdate2+"件(2件目)のデータを操作しました");

        //     } catch (SQLException ex) {
        //       con.rollback();
        //       ex.printStackTrace();
        //     }

        try {
            con=DriverManager.getConnection(url, user, password);
                    // String sql1="""
                        sql1="""
                        begin;
                        drop table
                        if exists colors;

                        create table colors
                        (id integer primary key,
                            name text
                        )
                        ;
                """;

            // String sql2="""
                sql2="""
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

                pstmt1=con.prepareStatement(sql1);                    //SQLの実行準備（rsに結果が代入される）
                pstmt2=con.prepareStatement(sql2);                    //SQLの実行準備（rsに結果が代入される）
                
                int numOfUpdate1=pstmt1.executeUpdate();
                int numOfUpdate2=pstmt2.executeUpdate();

                
                System.out.println(numOfUpdate1+"件のデータを操作しました");
                System.out.println(numOfUpdate2+"件のデータを操作しました");


        } catch (SQLException e) {
            System.err.println("SQLの接続時にエラーが発生しました"+sql1+"+"+sql2);
            e.printStackTrace();
        }finally{

            try {
                if (con !=null) {
                    con.close();
                }
                if (pstmt1 !=null) {
                    pstmt1.close();
                }
                if (pstmt2 !=null) {
                    pstmt2.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
