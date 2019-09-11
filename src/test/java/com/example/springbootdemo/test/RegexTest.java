package com.example.springbootdemo.test;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @className RegexTest
 * @Description TODO
 * @Author zhaoteng
 * @Date 2019/7/10 9:21
 * @Version 1.0
 **/
public class RegexTest {

    @Test
    public void test1() {
        String regex = "zo*";
        boolean z = Pattern.matches(regex, "z");
        System.out.println(z);
    }

    @Test
    public void test2() {
        // 按照指定模式在字符串中查找
        String line = "This order was placed for QT3000! OK?";
        String regex = "(\\D*)(\\d+)(.*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            System.out.println(matcher.groupCount());
            // System.out.println("Found value: " + matcher.group(0) );
            System.out.println("Found value: " + matcher.group(1) );
            System.out.println("Found value: " + matcher.group(2) );
            System.out.println("Found value: " + matcher.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }

    // \b(\w+)\b\s+\1\b
    @Test
    public void test3() {
        String regex = "\\b(\\w+)\\b\\s+\\1\\b";
        boolean z = Pattern.matches(regex, "go go");
        System.out.println(z);
    }

    @Test
    public void test4() {
        String str="(中文问号？123???英文)问号?我是华丽[的制表符\t]我是华丽{的空格符 我是华丽}的换行符\n";
        String rex="\\b";

        Pattern pattern=Pattern.compile(rex);
        Matcher matcher=pattern.matcher(str);

        String [] result=pattern.split(str);

        for(String string:result){
            System.out.println("分割的字符串:"+"["+string+"]");
        }
    }
}
