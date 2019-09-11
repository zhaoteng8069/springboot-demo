package com.example.springbootdemo.util;


import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.model.DemoModel;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @className DateUtils
 * @Description TODO
 * @Author zhaoteng
 * @Date 2019/7/9 13:33
 * @Version 1.0
 **/
public class DateUtils {

    public static Date add(Date date, int file, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(file, amount);
        return calendar.getTime();
    }



    public static void main(String[] args) {

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("key1", "111");
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("heheh", "222");
        jsonObject1.put("key2", jsonObject2);
        System.out.println(jsonObject1.toJSONString());

        DemoModel model = new DemoModel();
        model.setId("dsds");
        model.setNum("222");
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("key3", "lll");
        model.setObject(jsonObject3);
        System.out.println(JSONObject.toJSONString(model));
    }


}
