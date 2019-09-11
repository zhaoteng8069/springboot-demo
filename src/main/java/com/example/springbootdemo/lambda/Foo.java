package com.example.springbootdemo.lambda;

/**
 * @className LambdaService
 * @Description TODO
 * @Author zhaoteng
 * @Date 2019/9/11 17:31
 * @Version 1.0
 **/
public class Foo {

    private String value = "Enclosing scope value";

    public String scopeExperiment() {
        Foo fooIC = new Foo() {
            String value = "Inner Class value";

        };
        return null;
    }

}
