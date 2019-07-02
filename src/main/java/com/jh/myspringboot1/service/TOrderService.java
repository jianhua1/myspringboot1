package com.jh.myspringboot1.service;

import com.jh.myspringboot1.dao.TOrderDao;
import com.jh.myspringboot1.modal.TOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Service
public class TOrderService {
    @Autowired
    private TOrderDao tOrderDao;


    public List<TOrder> getAll(){
        return tOrderDao.getAll();
    }

    public List<TOrder> getByCondition(TOrder tOrder){
        return tOrderDao.getByCondition(tOrder);
    }


    @Transactional(rollbackFor = Exception.class)
    public void addTest2(TOrder tOrder) throws Exception{
            System.out.println("+++++aaaaaaaaa");
            tOrderDao.save(tOrder);
         /*   File f=new File("k:/xxx");
            f.createNewFile();
            FileOutputStream fileOutputStream=new FileOutputStream(f);
            fileOutputStream.write(new byte[1024]);
            System.out.println("jjjjjjjjjjj");*/
    }

}
