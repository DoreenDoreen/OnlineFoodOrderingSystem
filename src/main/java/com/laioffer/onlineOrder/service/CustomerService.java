package com.laioffer.onlineOrder.service;

import com.laioffer.onlineOrder.dao.CustomerDao;
import com.laioffer.onlineOrder.entity.Cart;
import com.laioffer.onlineOrder.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {    // Service 这一层不会直接去跟数据库进行操作，只会调用Dao里面的变量或函数

    @Autowired
    private CustomerDao customerDao;

    // 调用 customerDao 的 signUp
    public void signUp(Customer customer) {
        // 由于 Customer class 里的member fields 可以从前端传进来的数据里获得，但除了 enabled he cart 这俩变量，
        // 所以需要我们去手动设置下这两个变量在这里
        customer.setEnabled(true);  // 所以先要把这个 customer 给设置成 enable true

        Cart cart = new Cart();  // 再创建一个 cart, 并给这个 用过户分配一个 cart
        customer.setCart(cart);  // 当数据库save这个用户时，同样也会保存这个cart记录

        customerDao.signUp(customer);
    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }

}
