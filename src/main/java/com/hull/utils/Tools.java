package com.hull.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2016/11/15.
 */
public class Tools {

    /**
     * 获取32位UUID
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 按时间格式获取订单号
     * @return
     */
    public static String getMasterOrderNo(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     *  获取itemId
     * @param orderNo
     * @param n
     * @return
     */
    public static String getItemId(String orderNo,int n){
        String itemId = "00"+n;
        itemId = itemId.substring(itemId.length()-3,itemId.length());
        return orderNo+itemId;
    }

    public static void main(String[] args){
        System.out.print(getItemId("123",111));
    }
}
