package com.jh.myspringboot1.dao;

import com.jh.myspringboot1.modal.TOrder;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TOrderDao {


     int save(TOrder tOrder);

     List<TOrder> getAll();
     List<TOrder> getByCondition(TOrder tOrder);


}
