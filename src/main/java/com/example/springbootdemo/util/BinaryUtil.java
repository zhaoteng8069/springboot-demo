package com.example.springbootdemo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.model.DemoModel;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.MAX_RADIX;
import static java.lang.Character.MIN_RADIX;

/**
 * @className BinaryUtil
 * @Description TODO
 * @Author zhaoteng
 * @Date 2019/7/26 15:58
 * @Version 1.0
 **/
public class BinaryUtil {
    public static void error() {
        int a = 1 / 0;
    }
    /**
     * 16进制字符串转换为byte数组
     * @param hexStr
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] hexStr2ByteArr(String hexStr) throws UnsupportedEncodingException {
        byte[] arrB = hexStr.getBytes("UTF-8");
        for (int i = 0; i < arrB.length; i++) {
            System.out.println(String.format("###hexStr->byteArr->%d::%S", i, JSONArray.toJSONString(arrB[i])));
        }

        int length = arrB.length;

        // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
        byte[] arrOut = new byte[length / 2];
        for (int i = 0; i < length; i+=2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }
    public void binaryToDecimal(int n){
        int t = 0;  //用来记录位数
        int bin = 0; //用来记录最后的二进制数
        int r = 0;  //用来存储余数
        while(n != 0){
            r = n % 2;
            n = n / 2;
            bin += r * Math.pow(10,t);
            t++;
        }
        System.out.println(bin);
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
       /* Map<String, Object> map = new HashMap<>();
        Object orDefault = map.getOrDefault("", new ArrayList<>());
        List<String> list = new ArrayList<>();
        list.forEach();*/
    }
}
