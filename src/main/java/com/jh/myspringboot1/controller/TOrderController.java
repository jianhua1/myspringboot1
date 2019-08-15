package com.jh.myspringboot1.controller;

import com.jh.myspringboot1.modal.TOrder;
import com.jh.myspringboot1.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class TOrderController {
    @Autowired
    private TOrderService tOrderService;
    @GetMapping(value = "/get_test")
    public void getTest(){
        System.out.println("aaagggggggg");
        System.out.println("aaagggggggg");
        List<TOrder> all = tOrderService.getAll();
        System.out.println("ggggggggggggggggggggg");
        List<TOrder> all2 = tOrderService.getAll();
        List<TOrder> all3 = tOrderService.getAll();
        all.forEach(o->{
            System.out.println(o.getOrderId()+" "+o.getUserId()+" "+o.getCreateDateTime());
        });
    }

    //http://localhost:8080/by_condition/1/save22
    @GetMapping(value = "/by_condition/{userId}/{status}")
    public void getByCondition(@PathVariable Integer userId,@PathVariable String status){
        TOrder tOrder=new TOrder();
        tOrder.setUserId(userId);
        tOrder.setStatus(status);
        List<TOrder> list=tOrderService.getByCondition(tOrder);
        list.forEach(o->{
            System.out.println("id:"+o.getOrderId()+" "+o.getUserId()+" "+o.getCreateDateTime());
        });
    }

    //http://localhost:8080/by_condition_norest?userId=1&status=save22
    @GetMapping("/by_condition_norest")
    public void getByConditionNoRest(Integer userId,String status){
        TOrder tOrder=new TOrder();
        tOrder.setUserId(userId);
        tOrder.setStatus(status);
        List<TOrder> list=tOrderService.getByCondition(tOrder);
        list.forEach(o->{
            System.out.println(o.getOrderId()+" "+o.getUserId()+" "+o.getCreateDateTime());
        });
    }

    @Transactional(rollbackFor = Exception.class)
    @GetMapping(value = "/add_test1")
    public void addTest1(){
        try{
            CopyOnWriteArrayList list = new CopyOnWriteArrayList();
            TOrder tOrder=new TOrder();
            tOrder.setStatus("false");
            tOrder.setUserId(9995);
            tOrderService.addTest2(tOrder);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/add_test2")
    public void addTest2(){
        try{
            TOrder tOrder=new TOrder();
            tOrder.setStatus("false");
            tOrder.setUserId(9999);
            tOrderService.addTest2(tOrder);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
