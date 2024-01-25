import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {                //DB接続、切断を行うクラス
    
    private final static String URL="jdbc:postgresql://localhost:5432/student";             //DB接続情報
    private final static String USER_NAME="postgres";
    private final static String PASSWORD="postgres";

    public static Connection createConnection(){            //DB接続を行うメソッド
        try {
            Connection con=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("DB接続失敗しました",e);
        }
    }

    public static void closeConnection(Connection con){             //DB切断を行うメソッド
        try {
            if (con !=null) {
                con.close();
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("DB切断失敗しました",ex);
        }
    }
}
