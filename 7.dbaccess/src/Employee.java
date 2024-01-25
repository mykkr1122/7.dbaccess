public class Employee {
    private Integer id;                     //フィールド変数の宣言
    private String name;
    private Integer age;
    private String gender;
    private Integer departmentId;

    public Integer getId() {                //getter,setter,toStringメソッドの宣言
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public Integer getDepartmentId() {
        return departmentId;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", departmentId="
                + departmentId + "]";
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
       this.name = name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setGender(String gender) {
       this.gender=gender;
    }
    public void setDepartmentId(Integer departmentId) {
       this.departmentId=departmentId;
    }
    
}
