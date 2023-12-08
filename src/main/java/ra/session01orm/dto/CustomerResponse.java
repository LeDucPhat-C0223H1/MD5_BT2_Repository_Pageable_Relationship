package ra.session01orm.dto;

import java.util.Date;

public class CustomerResponse {
    private Long id;
    private String name;
    private String phone;
    private Boolean sex;
    private Date birthDay;
    private String area;

    public CustomerResponse() {
    }

    public CustomerResponse(Long id, String name, String phone, Boolean sex, Date birthDay, String area) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.birthDay = birthDay;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
