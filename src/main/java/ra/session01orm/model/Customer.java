package ra.session01orm.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

// Entity
@Entity // chú thích lớp ánh xạ
@Table(name = "Customers")
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO) // cấu hình tự sinh id
    private Long id;

    @Column(name = "customer_name")
    private String name;

    @Column(unique = true)
    private String phone;

    private Boolean sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Column(name = "address_id")
    private String addressId;


    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Customer() {
    }

    public Customer(Long id, String name, String phone, Boolean sex, Date birthday, String addressId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.birthday = birthday;
        this.addressId = addressId;
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

    public Date getBirthday() {
        return birthday;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
}
