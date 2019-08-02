package com.example.springbootdemo.util;

import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;

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
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.SECOND));
        System.out.println(String.format("%02d", calendar.get(Calendar.SECOND)));
    }


}
