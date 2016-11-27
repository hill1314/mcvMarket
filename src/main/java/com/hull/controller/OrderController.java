package com.hull.controller;

import com.hull.entity.MasterOrder;
import com.hull.entity.OrderItem;
import com.hull.entity.Product;
import com.hull.module.MasterOrderVo;
import com.hull.service.MasterOrderService;
import com.hull.service.OrderItemService;
import com.hull.service.ProductService;
import com.hull.utils.ILog;
import com.hull.utils.JacksonUtils;
import com.hull.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/11/27.
 */
@Controller
@RequestMapping("order")
public class OrderController implements ILog{
    @Resource
    ProductService productService;
    @Resource
    MasterOrderService masterOrderService;
    @Resource
    OrderItemService orderItemService;

    @RequestMapping("newOrder")
    public Object newOrder(){
        return "order/newOrder";
    }

    @RequestMapping("payInfo")
    public Object payInfo(String prodIds){
        logger.info(prodIds);
        String[] ids = prodIds.split(",");
        List products = new ArrayList();
        for(int i=0;i<ids.length;i++){
            Product product =productService.selectByPrimaryKey(ids[i]);
            products.add(product);
        }
        ModelAndView view = new ModelAndView("order/payInfo");
        view.addObject("products",products);
        return view;
    }

    @RequestMapping("payOrder")
    @ResponseBody
    public Object payOrder(MasterOrderVo orderInfo){
//        try {
//            HashMap<String,Object> paraMap = (HashMap<String, Object>) JacksonUtils.json2Obj(orderInfo,HashMap.class);
//
//            HashMap<String,String> order = (HashMap<String, String>) paraMap.get("masterOrder");
//            String custId = order.get("custId");
//            BigDecimal totalPrice = new BigDecimal(order.get("totalPrice").toString());
//            BigDecimal realyPay = new BigDecimal(order.get("realyPay").toString());
//            String status = order.get("status");
//
//            //保存主订单
//            masterOrderService.createNewOrder(custId,totalPrice,realyPay,status);
//
//            ArrayList<HashMap<String,String>> orderItems = (ArrayList<HashMap<String, String>>) paraMap.get("orderItems");
//
//            for(HashMap<String,String> item : orderItems){
//                String prodId =item.get("prodId");
//                String prodNum = item.get("prodNum");
//
//                Product prod = productService.selectByPrimaryKey(prodId);
//                OrderItem orderItem = new OrderItem();
//                orderItem.setProdId(prodId);
//                int num = NumberUtils.parseNumber(prodNum,Integer.class);
//                orderItem.setProdNum(num);
//                orderItem.setItemPrice(prod.getStandPrice().multiply(BigDecimal.valueOf(num)));
//
//
////                orderItemService.insert();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        String jsonStr = "";
        HashMap<String,String> resultMap = new HashMap();
        resultMap.put("resultCode","0000");
        resultMap.put("resultMsg","success");
        try {
            jsonStr = JacksonUtils.obj2Json(resultMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
