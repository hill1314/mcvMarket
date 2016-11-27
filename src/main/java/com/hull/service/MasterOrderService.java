package com.hull.service;

import com.hull.entity.MasterOrder;
import com.hull.module.MasterOrderVo;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/11/13.
 */
public interface MasterOrderService {
    int deleteByPrimaryKey(String orderNo);

    int insertSelective(MasterOrder record);

    MasterOrder selectByPrimaryKey(String orderNo);

    int updateByPrimaryKeySelective(MasterOrder record);

    int updateByPrimaryKey(MasterOrder record);

    void createNewOrder(MasterOrderVo masterOrderVo) throws Exception;
}
