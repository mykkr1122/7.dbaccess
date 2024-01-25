import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDao {
    public Department load(Integer id) {

        Connection con=DBManager.createConnection();

        String sql="select id,name from departments where id=?";

        try {
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs=pstmt.executeQuery();

            if (rs.next()) {
                Department department=new Department();

                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                return department;
            }
            return null;

        } catch (SQLException ex) {
            System.err.println("SQL= "+sql);
            throw new RuntimeException("load処理に失敗しました",ex);
        }finally{
            DBManager.closeConnection(con);
        }
    }

    public int insert (Department department){
        
        Connection con=DBManager.createConnection();
        String sql="""
                insert into employees
                (id,name)
                values
                (?,  ? )
                """;
        try {
            PreparedStatement pstmt=con.prepareStatement(sql);

            pstmt.setInt(1, department.getId());
            pstmt.setString(2, department.getName());

            int affected=pstmt.executeUpdate();
            return affected;
        } catch (SQLException ex) { 
            System.err.println("SQL= "+sql);
            throw new RuntimeException("insert処理に失敗しました",ex);

        }finally{
            DBManager.closeConnection(con);
        }
    }

    public int update (Department department){
        
        Connection con=DBManager.createConnection();
        String sql="""
                update departments
                set
                name=?,
                where id=?
                """;
        try {
            PreparedStatement pstmt=con.prepareStatement(sql);

            pstmt.setString(2, department.getName());

            int affected=pstmt.executeUpdate();
            return affected;
        } catch (SQLException ex) { 
            System.err.println("SQL= "+sql);
            throw new RuntimeException("insert処理に失敗しました",ex);

        }finally{
            DBManager.closeConnection(con);
        }
    }
    
}
