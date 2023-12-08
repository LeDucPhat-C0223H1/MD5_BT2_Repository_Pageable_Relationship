package ra.session01orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.session01orm.dao.CustomerDao;
import ra.session01orm.model.Customer;

import java.util.Date;

@Controller
@RequestMapping("")
public class HomeController {
    @Autowired
    private CustomerDao customerDao;

    @RequestMapping("/add")
    public String showHome(){
        Customer c = new Customer(null, "Trần Văn C ", "0932796875", true, new Date() );
        customerDao.save(c);
        return "home";
    }

    @RequestMapping("/delte/{id}")
    public String doDelete(@PathVariable Long id){
        customerDao.delete(id);
        return "home";
    }
}
