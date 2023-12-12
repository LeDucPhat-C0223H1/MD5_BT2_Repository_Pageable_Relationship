package ra.session01orm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import ra.session01orm.model.Customer;

import java.util.List;

public interface ICustomerServive {
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Long id);
    Customer findAllByName(String query, Pageable pageable);
    void save(Customer customer);
    void update(Customer customer);
    void delete(Long id);
}
