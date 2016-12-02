package com.hull.dao;

import com.hull.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(String prodId) throws Exception;

    int insertSelective(Product record) throws Exception;

    Product selectByPrimaryKey(String prodId) throws Exception;

    int updateByPrimaryKeySelective(Product record) throws Exception;

    List<Product> selectAll(Product prod);
}