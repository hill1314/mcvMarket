package com.hull.service;

import com.hull.dao.ProductMapper;
import com.hull.entity.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/11/15.
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Resource
    ProductMapper productMapper;

    @Override
    public int deleteByPrimaryKey(String prodId) {
        try {
            return productMapper.deleteByPrimaryKey(prodId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

//    @Override
//    public int insert(Product record) {
//        return 0;
//    }

    @Override
    public int insertSelective(Product record) {
        try {
            return productMapper.insertSelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Product selectByPrimaryKey(String prodId) {
        try {
            return productMapper.selectByPrimaryKey(prodId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        try {
            return productMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

//    @Override
//    public int updateByPrimaryKey(Product record) {
//        return 0;
//    }
}
