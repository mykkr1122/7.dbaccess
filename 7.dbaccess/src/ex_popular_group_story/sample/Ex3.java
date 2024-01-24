package ex_popular_group_story.sample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex3 {
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/student";
        String user="postgres";
        String password="postgres";

        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql=null;

        try {
            con=DriverManager.getConnection(url, user, password);

            sql="""
                select
                *
                from
                members
                ;
            """;
            
            pstmt=con.prepareStatement(sql);

            rs=pstmt.executeQuery();

            while (rs.next()) {
                
                String name=rs.getString("name");
                Date birth_day=rs.getDate("birth_day");
                String gender=rs.getString("gender");
                int color_id=rs.getInt("color_id");

                System.out.println("name="+name);
                System.out.println("birth_day ="+birth_day);
                System.out.println("gender= "+ gender);
                System.out.println("color_id="+color_id);

                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println();
            System.err.println("SQL関連の例外が発生しました");          
                System.err.println("発生したSQLは「"+sql+"」です");         //どんな操作をしたのかわかるように親切に書いている
                ex.printStackTrace();
        } finally{                                  //finallyでclose処理しないとメモリ圧迫する
                try {
                    if (con !=null) {               
                        con.close();
                    }
                    if (pstmt !=null) {
                        pstmt.close();
                    }
                    if (rs !=null) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}