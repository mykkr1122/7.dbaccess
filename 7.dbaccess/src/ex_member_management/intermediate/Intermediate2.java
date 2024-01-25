package ex_member_management.intermediate;

import java.util.List;

public class Intermediate2 {
    public static void main(String[] args) {
        EmployeeDao employeeDao=new EmployeeDao();

        List<Employee> employeeList=employeeDao.findAll(1);
        for(Employee el:employeeList){
            System.out.println("name="+el.getName());
        }


    }
}
