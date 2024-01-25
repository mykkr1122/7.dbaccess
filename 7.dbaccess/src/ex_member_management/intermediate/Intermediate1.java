package ex_member_management.intermediate;

public class Intermediate1 {
    public static void main(String[] args) {
        EmployeeDao employeeDao=new EmployeeDao();
        Employee employee =employeeDao.load(1);
        System.out.println(employee);
    }
}
