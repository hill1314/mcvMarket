package com.hull.service;

import com.hull.dao.OrderItemMapper;
import com.hull.entity.OrderItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/11/15.
 */
@Service
public class OrderItemServiceImpl implements OrderItemService{
    @Resource
    OrderItemMapper orderItemMapper;

    @Override
    public int deleteByPrimaryKey(String itemId) {
        try {
            return orderItemMapper.deleteByPrimaryKey(itemId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

//    @Override
//    public int insert(OrderItem record) {
//        try {
//            return orderItemMapper.insert(record);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }

    @Override
    public int insertSelective(OrderItem record) {
        try {
            return orderItemMapper.insertSelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public OrderItem selectByPrimaryKey(String itemId) {
        try {
            return orderItemMapper.selectByPrimaryKey(itemId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(OrderItem record) {
        try {
            return orderItemMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

//    @Override
//    public int updateByPrimaryKey(OrderItem record) {
//        try {
//            return orderItemMapper.updateByPrimaryKey(record);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
}
