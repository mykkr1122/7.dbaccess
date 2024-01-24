package ex_popular_group_story.sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex1 {
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
                    id,name
                    from
                    departments
                    ;
            """;
            
            pstmt=con.prepareStatement(sql);

            rs=pstmt.executeQuery();

            while (rs.next()) {
                int id=rs.getInt("id");
                String name=rs.getString("name");

                System.out.println("id="+id);
                System.out.println("name="+name);
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
