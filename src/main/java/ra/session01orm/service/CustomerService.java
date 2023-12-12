package ra.session01orm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.session01orm.model.Customer;
import ra.session01orm.reponsitory.ICustomerResponsitory;


@Service
public class CustomerService implements ICustomerServive{
    @Autowired
    private ICustomerResponsitory customerResponsitory;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 2, pageable.getSort());
        return customerResponsitory.findAll(pageable);
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public Customer findAllByName(String query, Pageable pageable) {

        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Long id) {

    }
}
