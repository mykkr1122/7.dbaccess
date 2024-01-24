import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectSample {

    public static void main(String[] args) {
        
        String url="jdbc:postgresql://localhost:5432/student";       //接続情報を書く　※url間違えない！
        String user="postgres";
        String password="postgres";

        Connection con=null;            //try の前で変数宣言（catchやfinallyで使いたいため）
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql=null;

      try {
            con=DriverManager.getConnection(url, user, password);       //DBに接続
            sql="select id,name,age from employees order by age";       //SQL文の作成（先にpgAdminでSQL文合っているか確認）
            //こんな書き方もあり
            // sql="""
            //     select
            //     id
            //     , name
            //     , age
            //     from
            //     employees
            //     order by 
            //     age   
            // """;
            pstmt=con.prepareStatement(sql);                    //SQLの実行準備（rsに結果が代入される）
            rs=pstmt.executeQuery();

            while(rs.next()){                                   //rs.next()  結果は列で帰ってきたりするので、次の列がある間true,なくなったらfalse
                int id=rs.getInt("id");             //list.get()に似てる　※DBの列名のデータ型に合わせる
                String name=rs.getString("name");
                int age=rs.getInt("age");


                System.out.println("id="+id);
                System.out.println("name="+name);
                System.out.println("age="+age);
                System.out.println();
            }
        } catch (SQLException ex) {                                     //検査例外ため、例外処理が必要
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