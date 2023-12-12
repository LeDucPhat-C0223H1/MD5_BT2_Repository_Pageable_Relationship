package ra.session01orm.model;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table (name = "zipcode")
public class ZipCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 100)
    private String name;
    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;
    @OneToMany (mappedBy = "zipCode")
    private List<Author> authorList;

    public ZipCode() {
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
}
