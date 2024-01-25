package ex_member_management.beginner;

import java.time.LocalDate;

public class Member {
    private Integer id;
    private String name;
    private LocalDate birthDay;
    private String gender;
    private Integer colorId;

    public Integer getId() {
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
    public LocalDate getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Integer getColorId() {
        return colorId;
    }
    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }
    
    @Override
    public String toString() {
        return "Member [id=" + id + ", name=" + name + ", birthDay=" + birthDay + ", gender=" + gender + ", colorId="
                + colorId + "]";
    }
    public void setDate(LocalDate localDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDate'");
    }
    public void setDate(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDate'");
    }
    public String getDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDate'");
    }
    
}
