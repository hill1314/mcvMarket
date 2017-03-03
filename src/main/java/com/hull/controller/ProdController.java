package com.hull.controller;

import com.hull.entity.Product;
import com.hull.entity.User;
import com.hull.service.ProductService;
import com.hull.utils.JacksonUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */

@Controller
@RequestMapping("/prod")
public class ProdController {
    final static Logger logger = Logger.getLogger(ProdController.class);

    @Resource
    ProductService productService;

    @RequestMapping(value = "/getProd",method = RequestMethod.GET)
    public Object getUser(String prodId){
        logger.info("prodId=="+prodId);
        Product product = productService.selectByPrimaryKey(prodId);
        ModelAndView view = new ModelAndView("product/prodInfo");
        view.addObject("product",product);
        return view;
    }

    @RequestMapping("/addProd")
    public Object addProd(){
        return "product/addProd";
    }
    @RequestMapping("/saveProd")
    public Object saveProd(Product product){
        int n = productService.insertSelective(product);
        if (n>0){
            return  "redirect:/prod/listView";
        }else{
            return  "redirect:/prod/addProd";
        }
    }

    @RequestMapping("/listView")
    public Object userListView(){
        return "product/prodList";
    }

    @RequestMapping("/prodList")
    @ResponseBody
    public Object userList(Product product){
        logger.info("prod list .. ");
        List<Product> prodList = productService.selectAll(product);
        String jsonStr = "";
        try {
            jsonStr = JacksonUtils.obj2Json(prodList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    @RequestMapping(value = "/delUser")
    public Object delUser(String prodId){
        logger.info("delete prod  "+prodId);
        productService.deleteByPrimaryKey(prodId);
        return  "redirect:/product/listView";
    }

}
