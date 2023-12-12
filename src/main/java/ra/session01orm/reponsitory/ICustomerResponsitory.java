package ra.session01orm.reponsitory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.session01orm.model.Customer;

@Repository
public interface ICustomerResponsitory extends PagingAndSortingRepository<Customer, Long> {
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
