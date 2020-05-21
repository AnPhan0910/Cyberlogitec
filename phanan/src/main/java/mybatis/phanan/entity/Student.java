package mybatis.phanan.entity;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private String branch;
    private int percentage;
    private String phone;
    private String email;
 
    public Student() {
    }
 
    public Student(String name, String branch, int percentage, String phone, String email) {
        super();
        this.name = name;
        this.branch = branch;
        this.percentage = percentage;
        this.phone = phone;
        this.email = email;
    }
     
    @Override
    public String toString() {
        return getClass().getName() + "[" + "id = " + id + ", name = " + name + ", branch = " + branch 
                + ", percentage = " + percentage  + ", phone = " + phone  + ", email = " + email + "]"; 
    }
}
