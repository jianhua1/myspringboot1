package com.jh.myspringboot1.controller;

import com.jh.myspringboot1.modal.TOrder;
import com.jh.myspringboot1.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TOrderController {
    @Autowired
    private TOrderService tOrderService;
    @GetMapping(value = "/get_test")
    public void getTest(){
        System.out.println("aaa");
        List<TOrder> all = tOrderService.getAll();
        all.forEach(o->{
            System.out.println(o.getOrderId()+" "+o.getUserId()+" "+o.getCreateDateTime());
        });
    }
}
