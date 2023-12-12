package ra.session01orm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.session01orm.model.Book;

@Controller
@RequestMapping("/book")
public class BookController {
    @RequestMapping("/add")
    public String add(){
        return "";
    }
}
