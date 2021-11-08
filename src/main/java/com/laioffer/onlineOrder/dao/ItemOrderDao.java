package com.laioffer.onlineOrder.dao;

import com.laioffer.onlineOrder.entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    // 去保存OrderItem对象
    public void save(OrderItem orderItem) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            //“写操作”一般会开启一个transaction
            session.beginTransaction();
            session.save(orderItem);
            session.getTransaction().commit();

        } catch (Exception ex) {  // 如果开启过程有问题，可以rollback
            ex.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {  // 最后close session
            if (session != null) {
                session.close();
            }
        }
    }

    // 删掉购物车里的某一个item 逻辑在其他的class里面去定义了
}
