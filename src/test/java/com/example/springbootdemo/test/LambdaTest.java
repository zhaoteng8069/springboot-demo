package com.example.springbootdemo.test;

import org.junit.Test;

import java.util.function.IntBinaryOperator;

/**
 * @className LambdaTest
 * @Description TODO
 * @Author zhaoteng
 * @Date 2019/9/11 17:22
 * @Version 1.0
 **/
public class LambdaTest {

    @Test
    public void test() {
        IntBinaryOperator intBinaryOperator = (int a, int b) -> {
            return a + b;
        };
        int i = intBinaryOperator.applyAsInt(1, 11);
        System.out.print(i);
    }



}
