package cn.sp.controller;

import cn.sp.bean.Order;
import cn.sp.repository.OrderRepository;
import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by 2YSP on 2018/9/23.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private IdGenerator idGenerator;

    @RequestMapping("/add")
    public String add(){
//        for(int i=0;i<10;i++){
//            Order order = new Order();
//            order.setOrderId((long) i);
//            order.setUserId((long) i);
//            repository.save(order);
//        }
        Order order = new Order();
        order.setUserId(1L);
        order.setOrderId(idGenerator.generateId().longValue());
        repository.save(order);
        return "success";
    }

    @RequestMapping("/query")
    public List<Order> queryAll(){
        List<Order> orders = (List<Order>) repository.findAll();
        return orders;
    }
}
