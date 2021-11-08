package com.laioffer.onlineOrder.controller;


import com.laioffer.onlineOrder.entity.Customer;
import com.laioffer.onlineOrder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller  // 用来标记该class以后用来作为Controller处理请求
public class SignUpController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)  // 处理完成后会自动存到数据库
    public void signUp(@RequestBody Customer customer) { // @RequestBody 主要用于POST请求，会把前端传进来的JSON 数据 通过 @RequestBody 会自动 创建/转换成 Customer class 的对象，给server端
                                                         //  并添加到数据库中，它是通过 Key 进行匹配的，也就是说 传进来的 key 和 Customer class fields 是要一一对应的
//        System.out.println(customer.getEmail());
        customerService.signUp(customer);

    }

}
