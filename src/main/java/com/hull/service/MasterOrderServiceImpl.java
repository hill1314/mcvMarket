package com.hull.service;

import com.hull.dao.MasterOrderMapper;
import com.hull.dao.OrderItemMapper;
import com.hull.dao.ProductMapper;
import com.hull.entity.MasterOrder;
import com.hull.entity.OrderItem;
import com.hull.entity.Product;
import com.hull.module.MasterOrderVo;
import com.hull.utils.Tools;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/11/15.
 */
@Service
public class MasterOrderServiceImpl implements MasterOrderService {
    @Resource
    MasterOrderMapper masterOrderMapper;
    @Resource
    ProductMapper productMapper;
    @Resource
    OrderItemMapper orderItemMapper;

    @Override
    public int deleteByPrimaryKey(String orderNo) {
        try {
            return masterOrderMapper.deleteByPrimaryKey(orderNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public int insertSelective(MasterOrder record) {
        try {
            return masterOrderMapper.insertSelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public MasterOrder selectByPrimaryKey(String orderNo) {
        try {
            return masterOrderMapper.selectByPrimaryKey(orderNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(MasterOrder record) {
        try {
            return masterOrderMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateByPrimaryKey(MasterOrder record) {
        try {
            return masterOrderMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void createNewOrder(MasterOrderVo masterOrderVo) throws Exception {
        String masterOrderNo = Tools.getMasterOrderNo();
        MasterOrder masterOrder = new MasterOrder();
        masterOrder.setOrderNo(masterOrderNo);
        masterOrder.setCreateTime(new Date());
        masterOrder.setUserId(masterOrderVo.getUserId());
        masterOrder.setTotalPrice(masterOrderVo.getTotalPrice());
        masterOrder.setRealyPrice(masterOrderVo.getRealyPrice());
        masterOrder.setStatus(masterOrderVo.getStatus());
        int n = masterOrderMapper.insert(masterOrder);

        List<OrderItem> orderItems = masterOrderVo.getOrderItems();
        int i = 0;
        for (OrderItem item : orderItems) {
            Product prod = productMapper.selectByPrimaryKey(item.getProdId());
            OrderItem orderItem = new OrderItem();
            orderItem.setProdId(item.getProdId());
            orderItem.setProdPrice(prod.getStandPrice());
            orderItem.setProdNum(item.getProdNum());
            orderItem.setItemPrice(prod.getStandPrice().multiply(BigDecimal.valueOf(item.getProdNum())));
            orderItem.setOrderNo(masterOrderNo);
            orderItem.setItemId(Tools.getItemId(masterOrderNo,i));
            orderItemMapper.insert(orderItem);
        }
    }
}
