package ra.session01orm.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ra.session01orm.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class CustomerDao {
    private static SessionFactory sessionFactory; // là nơi chưa các đối tượng ánh xạ về

    private static EntityManager entityManager; // cung cấp các phương thức quản lí các đối tượng
    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate-config.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }
    }

    public List<Customer> findAll(){
        // câu HQL - Hibernatequery language
        TypedQuery<Customer> typedQuery = entityManager.createQuery("SELECT C FROM Customer C",Customer.class); // định lớp thực hiện truy vấn
        return typedQuery.getResultList(); // trả về 1 danh sách
    }

    public Customer findById(Long id){
        TypedQuery<Customer> typedQuery = entityManager.createQuery("SELECT C FROM Customer C WHERE C.id = :id",Customer.class); // định lớp thực hiện truy vấn
        // truyền tham số
        typedQuery.setParameter("id",id);
        return typedQuery.getSingleResult();
    }

    // lưu ý các thao tác chỉnh sửa dữ liệu bắt phải có transaction mới thực hiện được
    public Customer save (Customer customer){
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession(); // mở ra 1 phiên làm việc
            transaction = session.beginTransaction(); // bắt đầu giao dịch
            //-----//
            session.saveOrUpdate(customer);
            transaction.commit();
            //----///
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return  customer;
    }

    public void delete(Long id){
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession(); // mở ra 1 phiên làm việc
            transaction = session.beginTransaction(); // bắt đầu giao dịch
            //-----//
            session.delete(findById(id));
            transaction.commit();
            //----///
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
    }
}
