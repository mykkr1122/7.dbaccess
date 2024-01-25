public class Department {
    private Integer id;
    private String name;        //フィールド変数の宣言
    
    public Integer getId() {            //getter,setter,toStringメソッドの宣言
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }

}
