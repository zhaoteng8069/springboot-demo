package com.example.springbootdemo.util;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class QEncodeUtil {

    /**
     * 将byte[]转为各种进制的字符串 
     * @param bytes byte[] 
     * @param radix 基数可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制 
     * @return 转换后的字符串
     */
    public static String binary(byte[] bytes, int radix){
        return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
    }

    public static void main(String[] args) throws ParseException {
        String startDateStr = "2019-01-01 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = sdf.parse(startDateStr);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        calendar.set(Calendar.HOUR_OF_DAY, -12);

        System.out.println(sdf.format(calendar.getTime()));
    }
}