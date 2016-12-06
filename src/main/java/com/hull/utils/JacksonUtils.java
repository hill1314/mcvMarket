package com.hull.utils;


import org.apache.ibatis.javassist.bytecode.stackmap.TypeData;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/19.
 */
public class JacksonUtils {

    /**
     *   Convert object to JSON string
     * @param obj
     * @return
     * @throws IOException
     */
    public static String obj2Json(Object obj) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(obj);
//        System.out.println("Change Object to JSON String: " + jsonStr);
        return jsonStr;
    }

    /**
     * Convert Json string to Object
     * @param jsonStr
     * @param className
     * @return
     * @throws IOException
     */
    public static Object json2Obj(String jsonStr, TypeData.ClassName className) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Object obj = mapper.readValue(jsonStr, className.getClass());
        return obj;
    }

    public static Object json2Obj(String jsonStr, Class className) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Object obj = mapper.readValue(jsonStr, className);
        return obj;
    }


    public static void main(String[] args) {
        try {
            String str = "{\"message\":\"获取成功\",\"result\":\"1\",\"data\":[{\"goodsList\":[{\"pictrue_url\":\"http://139.196.81.14/FileSave/File/userFile/33391593.png\",\"sale_money\":\"100\",\"th_address\":\"222222\",\"goods_number\":\"2\",\"store_id\":\"33391593\",\"goods_name\":\"wqw\",\"goods_jfrate\":\"1\",\"member_id\":\"918d888cf691464ab391e4a345a9741c\",\"gf_salemoney\":\"2222\",\"gg_miaosu\":\"测试商品1号\",\"shopcart_id\":\"201612020228504758\",\"goods_id\":\"1\",\"goods_type\":\"2\",\"store_name\":\"金溪测试three\"}],\"pictrue_url\":\"http://139.196.81.14/FileSave/File/userFile/33391593.png\",\"goods_type\":\"2\",\"store_id\":\"33391593\",\"store_name\":\"金溪测试three\",\"member_id\":\"918d888cf691464ab391e4a345a9741c\"}]}";

            HashMap map = (HashMap) JacksonUtils.json2Obj(str, Map.class);
            String message = (String) map.get("message");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
