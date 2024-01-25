package ex_member_management.intermediate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public Employee load(int id){                    
        Connection con=DBManager.createConnection();

        String sql="""
            select id,name,age,gender,department_id ,departments.name as department_name
            from employees 
            join departments
            on employees.department_id=departments.id
            where id=?"
            ;
                    
            """;

        try {
            PreparedStatement pstmt=con.prepareStatement(sql);
           
            pstmt.setInt(1,id);             
            ResultSet rs=pstmt.executeQuery();

            if (rs.next()) {                
                Employee employee =new Employee();              
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setAge(rs.getInt("age"));
                employee.setGender(rs.getString("gender"));
                employee.setDepartmentId(rs.getInt("department_id"));
                employee.setName(rs.getString("departmemt_name"));
                return employee;  
            }                             
            return null;                                           

        } catch (SQLException ex) {
            System.err.println("SQL= "+sql);
            throw new RuntimeException("load処理に失敗しました",ex);
        }finally{
            DBManager.closeConnection(con);
        }
    }

        public List<Employee> findAll(int departmentId){
            Connection con=DBManager.createConnection();
            String sql="""
                select id,name,gender,department_id,detartments.name as department_name
                from empoyees
                join departments
                on employees.department_id=departments.id
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
                employee.setName(rs.getString("departmemt_name"));

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

     public int deleteByDepartmentId(int departmentId){
        Connection con=DBManager.createConnection();
        String sql="""
                delete from employees
                join departments
                on employees.department_id=departments.id
                where id=?
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
                employee.setName(rs.getString("departmemt_name"));

                employeeList.add(employee);
                }
                return employeeList;
        } catch (SQLException ex) { 
            System.err.println("SQL= "+sql);
            throw new RuntimeException("delete処理に失敗しました",ex);

        }finally{
            DBManager.closeConnection(con);
        }
    }
}



