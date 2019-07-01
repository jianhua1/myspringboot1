package com.jh.myspringboot1.service;

import com.jh.myspringboot1.dao.TOrderDao;
import com.jh.myspringboot1.modal.TOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TOrderService {
    @Autowired
    private TOrderDao tOrderDao;

    public List<TOrder> getAll(){
        return tOrderDao.getAll();
    }

}
