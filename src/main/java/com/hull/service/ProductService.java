package com.hull.service;

import com.hull.entity.Product;

import java.util.List;

/**
 * Created by Administrator on 2016/11/13.
 */
public interface ProductService {
    int deleteByPrimaryKey(String prodId);

//    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String prodId);

    int updateByPrimaryKeySelective(Product record);

//    int updateByPrimaryKey(Product record);

    public List<Product> selectAll(Product prod);
}
