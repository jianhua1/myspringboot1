package com.jh.myspringboot1.dao;

import com.jh.myspringboot1.modal.TOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface TOrderDao {
     List<TOrder> getAll();
}
