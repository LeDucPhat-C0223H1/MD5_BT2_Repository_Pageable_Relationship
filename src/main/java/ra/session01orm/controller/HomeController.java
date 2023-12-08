package ra.session01orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.session01orm.model.Customer;
import ra.session01orm.reponsitory.ICustomerReponsitory;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class HomeController {
    @Autowired
    private ICustomerReponsitory customerReponsitory;

    @RequestMapping("/add")
    public String showHome(){
        Customer c = new Customer(null, "Đặng Văn B ", "0932796875", true, new Date(),"A001" );
        customerReponsitory.save(c);
        return "home";
    }

    @RequestMapping("/delete/{id}")
    public String doDelete(@PathVariable Long id){
        customerReponsitory.deleteById(id);
        return "home";
    }

    @RequestMapping("/search/{name}")
    public String doSearch(@PathVariable String name){
        List<Customer> customers = customerReponsitory.findAllByNameContainingIgnoreCase(name);
        return "home";
    }
}
