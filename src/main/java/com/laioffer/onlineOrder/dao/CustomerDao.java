package com.laioffer.onlineOrder.dao;

import com.laioffer.onlineOrder.entity.Authorities;
import com.laioffer.onlineOrder.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {   // Dao 这一层会直接跟数据库进行操作

    @Autowired
    private SessionFactory sessionFactory;

    public void signUp(Customer customer) {
        Session session = null;

        // 目的：用户在注册时，给他分配一个权限
        Authorities authorities = new Authorities();  // 先创建 Authorities object
        authorities.setEmail(customer.getEmail());  // 把从 Customer instance 里拿到的 email 设置成 这个 authority object 的 email
        authorities.setAuthorities("ROLE_USER");   // 再把该 authority object 设置为 “ROLE_USER”, 在以后 logIn 的时候我们去检查该用户有没有 “ROLE_USER” 这个值就好，有的话就允许访问，没有的话就拒绝这个请求
                                                   // 为以后的特殊身份登录用户的权限逻辑提前做好定义准备，会用在 security 框架里以后

        try {
            session = sessionFactory.openSession();  // 通过使用 sessionFactory.openSession() 去拿到一个 session object
            session.beginTransaction();  // 启动一个 session
            session.save(authorities);  // .save() 功能：hibernate会把memory里的 authorities instance/对象 保存/添加 到数据库的 authorities table 里面
            session.save(customer);   // 同上，hibernate会把memory里的 customer instance保存到数据库的 customer table 里面
            session.getTransaction().commit();   // 为了避免一张表插入成功，而另一张表的插入失败了，我就把这两张表的操作定义在transaction里面，这样的话，数据库可以保证这两部张表的操作要么都成要么都失败。
                                                // .getTransaction() 自动会去数据库里提交这两张表操作的任务， 如果不抛异常的话，说明 .commit() 操作成功；反之若抛了异常，可以通过 session 提供的方法，回到transaction之前的状态

        } catch (Exception ex) {
            ex.printStackTrace();   // print 一下错误的原因
            if (session != null) session.getTransaction().rollback();   // 若session不为空，就先拿到这个这个 transaction，使用 .rollback() 可以使数据库自动回滚到transaction之前的状态，这样可以保证数据库里所有的操作都没发生过。
        } finally {
            if (session != null) session.close();   // 用完之后记得close, 否则没办法reuse
        }


    }

    public Customer getCustomer(String email) {  // 从 DB 里 select 一个 customer 对象
        Customer customer = null;  // 先创建一个 customer instance
        Session session = null;  // 创建一个session
        try {
            session = sessionFactory.openSession();  // 通过 sessionFactory.openSession() 拿到一个 session object
            // 因为“读操作”不会涉及到 concurrency的问题，所以这里我们不用去开启一个transaction
            // 如果将来遇到了 “读和写” 同时发生的情况，有可能会造成 读到了别人还没写完的数据，那就有可能会用到 transaction
            // 但我们这里没有涉及到这个问题，所以就不用开始一个 transaction了可以直接通过 .get() 操作
            customer = session.get(Customer.class, email);  // .get() 里面会传入的两个参数：Customer.class 这个table 以及 email是主键, 会去Customer这张表里面根据主键找到具体的记录，看看有没有，有的话就返回这个entity，没有的话就返回Null,表示记录不存在。
                                                            // 从而获得一条具体的记录,即某一行
                                                            // 会默认mapping 这行记录到customer 对象上面
        } catch (Exception ex ) {
            ex.printStackTrace(); // 如果有异常的话就打印一下，也可以 throwExceptions
        } finally {
            if (session != null) session.close();   // 最后记得 close session
        }
        return customer;   // 最后记得 return customer
    }

}
