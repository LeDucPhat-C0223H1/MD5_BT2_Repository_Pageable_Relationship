package ra.session01orm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.session01orm.dao.CustomerDao;
import ra.session01orm.model.Customer;
import ra.session01orm.reponsitory.ICustomerResponsitory;
import ra.session01orm.service.ICustomerServive;

import java.util.Date;


@Controller
@RequiredArgsConstructor
@RequestMapping("")
public class HomeController {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ICustomerServive customerServive;

    @RequestMapping({"", "home"})
    public String showHome(){
        return "home";
    }

//    @RequestMapping("/add")
//    public String doAdd(){
//        Customer c = new Customer(null, "Trần Văn C ", "0932796875", true, new Date() );
//        customerResponsitory.save(c);
//        return "home";
//    }

//    @RequestMapping("/delte/{id}")
//    public String doDelete(@PathVariable Long id){
//        customerResponsitory.deleteById(id);
//        return "list-customer";
//    }

    @RequestMapping("/list-customer")
    private String pagination
            (Pageable pageable,
             Model model){
//            @RequestParam(name = "page", defaultValue = "0") int page,
//            @RequestParam(defaultValue = "5") int size,
//            @RequestParam(name = "sort",required = false) String typeSort,
//                    Model model
//
//    ){
//        Sort sorted = Sort.by("typeSort").descending();
//        Pageable pageabe = PageRequest.of(page,size); // trong pageable chuaw page, size, sort

        Page<Customer> customerPage = customerServive.findAll(pageable);
        model.addAttribute("customers", customerPage);
        return "list-customer";
    }
}
