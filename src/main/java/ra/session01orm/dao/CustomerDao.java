package ra.session01orm.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ra.session01orm.model.Customer;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CustomerDao {
    @PersistenceContext
    private  EntityManager entityManager;

    public List<Customer> findAll(){
        return entityManager.createQuery("select C from Customer c", Customer.class).getResultList();
    }

    public Customer findById(Long id){
        return entityManager.find(Customer.class, id);
    }

    // lưu ý các thao tác chỉnh sửa dữ liệu bắt phải có transaction mới thực hiện được
    @Transactional
    public void save (Customer customer){
        if (customer.getId() == null) {
            // thêm mới
            entityManager.persist(customer);
        }else {
            // cập nhật
            entityManager.merge(customer);
        }
    }
    @Transactional
    public void delete(Long id){
        entityManager.remove(findById(id));
    }
}
