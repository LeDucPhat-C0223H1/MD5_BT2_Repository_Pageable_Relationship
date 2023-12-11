package ra.session01orm.reponsitory;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ra.session01orm.dto.CustomerResponse;
import ra.session01orm.model.Customer;

import java.util.List;

public interface ICustomerReponsitory extends CrudRepository<Customer, Long>  {
    // không cần định nghĩa các phương thức có sẵn

    List<Customer> findAllByNameContainingIgnoreCase(String name);

    // Query
//    cách 1
//    @Query(value = "select  count(c.id) from Customer c where c.sex = :sex" )

//    cách 2
    @Query(nativeQuery = true, value = "select count(*) from customers where sex =: sex ")
    long countCustomerBySex(@Param("sex") Boolean sex);

    @Query(value = "SELECT new ra.session01orm.dto.CustomerResponse(c.id,c.name,c.phone,c.sex,c.birthDay,a.area) from Customer c join Address a on c.addressId=a.id")
    List<CustomerResponse> findCustomersWithAddress();
}
