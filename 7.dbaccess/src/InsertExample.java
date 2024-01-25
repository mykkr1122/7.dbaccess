public class InsertExample {
    public static void main(String[] args) {
        // EmployeeDao dao=new EmployeeDao();

        // Employee employee=new Employee();
        // employee.setId(1000);
        // employee.setName("テスト太郎");
        // employee.setAge(22);
        // employee.setGender("男");
        // employee.setDepartmentId(2);


        // dao.insert(employee);

        // employee=dao.load(1000);
        // System.out.println("id="+employee.getId());
        // System.out.println("name="+employee.getName());
        // System.out.println("age="+employee.getAge());
        // System.out.println("gender="+employee.getGender());
        // System.out.println("department_id="+employee.getDepartmentId());



        DepartmentDao dao2=new DepartmentDao();

        Department department=new Department();
        department.setId(1001);
        department.setName("システム情報部");

        dao2.insert(department);

        department=dao2.load(1000);

        System.out.println("id="+department.getId());
        System.out.println("name="+department.getName());

        // department = dao2.load(1000);

        // if (department != null) {
        //     System.out.println("id=" + department.getId());
        //     System.out.println("name=" + department.getName());
        // } else {
        //     System.out.println("Department with ID 1000 could not be loaded.");
        // }
    }

}
