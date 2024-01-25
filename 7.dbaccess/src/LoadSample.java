public class LoadSample {
    public static void main(String[] args) {
        EmployeeDao dao=new EmployeeDao();                  //EmployeeDaoクラスのインスタンス化

        Employee employee=dao.load(1);            //従業員情報を取得    

        System.out.println("id="+employee.getId());                 //従業員情報を出力
        System.out.println("name="+employee.getName());
        System.out.println("age="+employee.getAge());
        System.out.println("genqder="+employee.getGender());
        System.out.println("department_id="+employee.getDepartmentId());
    }
}
