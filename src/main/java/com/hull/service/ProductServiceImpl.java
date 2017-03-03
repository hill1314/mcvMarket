package com.hull.service;

import com.hull.dao.ProductMapper;
import com.hull.entity.Product;
import com.hull.entity.User;
import com.hull.utils.Tools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    @Override
    public int insertSelective(Product record) {
        try {
            record.setProdId(Tools.getUUID());
            record.setCreateTime(new Date());
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

    @Override
    public List<Product> selectAll(Product prod) {
        List<Product> prodList = new ArrayList<>();
        try {
            prodList = productMapper.selectAll(prod);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prodList;
    }

}
