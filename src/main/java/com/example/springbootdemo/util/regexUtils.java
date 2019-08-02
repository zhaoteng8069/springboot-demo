package com.example.springbootdemo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @className regexUtils
 * @Description TODO
 * @Author zhaoteng
 * @Date 2019/7/10 9:14
 * @Version 1.0
 **/
public class regexUtils {

    private static Logger logger = LoggerFactory.getLogger(regexUtils.class);

    private static void test1() {
        try {
            int a = 10 / 0;
        } catch (Exception e) {
            throw e;
        }
        finally {
            System.out.println("finally");
        }

        System.out.println("hello");
    }

    public static void main(String[] args) throws ParseException {
        // 开始时间
        String startDateStr = "2019-01-01 00:00:00";
        String endDateStr = "2019-07-15 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = sdf.parse(startDateStr);
        Date endDate = sdf.parse(endDateStr);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        // <= endDate
        for (Date d = startDate; d.before(endDate); d = calendar.getTime()) {
            //设置calendar递减
            calendar.add(Calendar.HOUR_OF_DAY, 6);

            // 如果某次时间递减的结果在规定时间之后了，不要忘记查询最后的范围
            if (calendar.getTime().after(endDate)) {
                // 获得原来的时间
                calendar.add(Calendar.HOUR_OF_DAY, -6);

                System.out.println(String.format("###最后一次查询时间段{%s}-{%s}###", sdf.format(d), sdf.format(calendar.getTime())));

                if (!calendar.getTime().equals(endDate)) {
                    /*dataForCentreService.orderData(sdf.format(d),sdf.format(calendar.getTime()));*/
                }
                // 跳出循环
                break;
            }

            System.out.println(String.format("###查询时间段{%s}-{%s}###", sdf.format(d), sdf.format(calendar.getTime())));

           /* dataForCentreService.orderData(sdf.format(d),sdf.format(calendar.getTime()));*/


        }
    }

}
