package com.hull.service;

import com.hull.dao.PayInfoMapper;
import com.hull.entity.PayInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/11/15.
 */
@Service
public class PayInfoServiceImpl implements PayInfoService{
    @Resource
    PayInfoMapper payInfoMapper;

    @Override
    public int deleteByPrimaryKey(String payId) {
        try {
            return payInfoMapper.deleteByPrimaryKey(payId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

//    @Override
//    public int insert(PayInfo record) {
//        return 0;
//    }

    @Override
    public int insertSelective(PayInfo record) {
        try {
            return payInfoMapper.insertSelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public PayInfo selectByPrimaryKey(String payId) {
        try {
            return payInfoMapper.selectByPrimaryKey(payId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(PayInfo record) {
        try {
            return payInfoMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

//    @Override
//    public int updateByPrimaryKey(PayInfo record) {
//        try {
//            return payInfoMapper.updateByPrimaryKey(record);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
}
