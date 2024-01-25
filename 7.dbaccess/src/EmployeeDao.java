import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDao {                                  //従業員情報を取得するクラス
    private static final String TABLE_NAME="employees";     //テーブル名(定数化)　※必須ではない

    public Employee load(int id){                       //従業員情報を取得するメソッド(引数は従業員ID、戻り値は従業員情報)
        Connection con=DBManager.createConnection();

        String sql="select id,name,age,gender,department_id from "+TABLE_NAME+" where id=?";

        try {
            PreparedStatement pstmt=con.prepareStatement(sql);
           
            pstmt.setInt(1,id);                 //SQL文の?に引数の従業員IDをセット
            ResultSet rs=pstmt.executeQuery();

            if (rs.next()) {                                        //従業員情報がある場合
                Employee employee =new Employee();            //従業員情報を格納するインスタンスを生成          
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setAge(rs.getInt("age"));
                employee.setGender(rs.getString("gender"));
                employee.setDepartmentId(rs.getInt("department_id"));
                return employee;                                //従業員情報を返す
            }
            return null;                                    //従業員情報がない場合はnullを返す              

        } catch (SQLException ex) {
            System.err.println("SQL= "+sql);
            throw new RuntimeException("load処理に失敗しました",ex);
        }finally{
            DBManager.closeConnection(con);
        }
    }

    //従業員情報を取得するメソッド(引数は部署ID、戻り値は従業員情報のリスト)
    public List<Employee> findByDepartmentId(int departmentId){
        Connection con=DBManager.createConnection();
        String sql="""
                select id,name,gender,department_id
                from empoyees
                where department_id=?
                """;
        
        try {
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setInt(1, departmentId);

            ResultSet rs=pstmt.executeQuery();
            List<Employee> employeeList=new ArrayList<>();

            while (rs.next()) {
                Employee employee=new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setAge(rs.getInt("age"));
                employee.setGender("gender");
                employee.setDepartmentId(rs.getInt("Department_id"));
                employeeList.add(employee);
            }
            return employeeList;
        } catch (SQLException ex) {
            System.err.println("SQL= "+sql);
            throw new RuntimeException("検索処理に失敗しました",ex);
        }finally{
            DBManager.closeConnection(con);
        }
    }

    //従業員情報を登録するメソッド(引数は従業員情報、戻り値は登録件数)
    public int insert(Employee employee){
        Connection con=DBManager.createConnection();
        String sql="""
                insert into employees
                (id,name,age,gender,department_id)
                values
                (?,  ? , ? , ? , ?)
                """;
        try {
            PreparedStatement pstmt=con.prepareStatement(sql);

            pstmt.setInt(1, employee.getId());
            pstmt.setString(2, employee.getName());
            pstmt.setInt(3,  employee.getAge());
            pstmt.setString(4, employee.getGender());
            pstmt.setInt(5, employee.getDepartmentId());

            int affected=pstmt.executeUpdate();
            return affected;
        } catch (SQLException ex) { 
            System.err.println("SQL= "+sql);
            throw new RuntimeException("insert処理に失敗しました",ex);

        }finally{
            DBManager.closeConnection(con);
        }
    }

     public int deleteById(int member){
        Connection con=DBManager.createConnection();
        String sql="""
                delete from employees
                where id=?
                """;
        try {
            PreparedStatement pstmt=con.prepareStatement(sql);

            pstmt.setInt(1, member);

            int affected=pstmt.executeUpdate();
            return affected;
        } catch (SQLException ex) { 
            System.err.println("SQL= "+sql);
            throw new RuntimeException("delete処理に失敗しました",ex);

        }finally{
            DBManager.closeConnection(con);
        }
    }
}
