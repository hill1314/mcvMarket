package com.hull.service;

import com.hull.dao.MasterOrderMapper;
import com.hull.dao.OrderItemMapper;
import com.hull.dao.PayInfoMapper;
import com.hull.dao.ProductMapper;
import com.hull.entity.MasterOrder;
import com.hull.entity.OrderItem;
import com.hull.entity.PayInfo;
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
    @Resource
    PayInfoMapper payInfoMapper;

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

//    @Override
//    public int updateByPrimaryKey(MasterOrder record) {
//        try {
//            return masterOrderMapper.updateByPrimaryKey(record);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }

    /**
     * 新建订单
     * @param masterOrderVo
     * @throws Exception
     */
    @Override
    public void createNewOrder(MasterOrderVo masterOrderVo) throws Exception {
        //计算 标准价格 与 实际结算价格 的差价
        BigDecimal cha = masterOrderVo.getTotalPrice().subtract(masterOrderVo.getRealyPrice());
        if(MasterOrderVo.OrderStatus.PAYED.equals(masterOrderVo.getStatus())
                && cha.compareTo(BigDecimal.TEN)>0){
            //TODO 差值大于10
        }
        //生成主订单号
        String masterOrderNo = Tools.getMasterOrderNo();
        //保存主订单
        MasterOrder masterOrder = new MasterOrder();
        masterOrder.setOrderNo(masterOrderNo);
        masterOrder.setCreateTime(new Date());
        masterOrder.setUserId(masterOrderVo.getUserId());
        masterOrder.setTotalPrice(masterOrderVo.getTotalPrice());   //订单总价格
        masterOrder.setRealyPrice(masterOrderVo.getRealyPrice());   //订单实际价格
        masterOrder.setPayPrice(masterOrderVo.getPayPrice());   //初始支付金额
        masterOrder.setStatus(masterOrderVo.getStatus());   //订单状态
        masterOrderMapper.insertSelective(masterOrder);
        //保存订单项
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
            orderItemMapper.insertSelective(orderItem);
        }
        //保存支付信息
        PayInfo payInfo = new PayInfo();
        payInfo.setPayId(Tools.getUUID());
        payInfo.setOrderNo(masterOrderNo);  //关联订单号
        payInfo.setOrderAmount(masterOrderVo.getRealyPrice());  //订单总价
        payInfo.setPayAmount(masterOrderVo.getPayPrice());      //支付金额
        payInfo.setOwedAmount(masterOrderVo.getRealyPrice().subtract(masterOrderVo.getPayPrice()));//欠款金额
        payInfo.setPayMan(masterOrderVo.getUserId());   //支付人
        payInfo.setPayTime(new Date());     //支付时间
        payInfo.setPayDesc(masterOrderVo.getNote());    //支付备注
        payInfoMapper.insertSelective(payInfo);
    }
}
