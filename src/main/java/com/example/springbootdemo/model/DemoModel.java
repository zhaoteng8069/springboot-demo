package com.example.springbootdemo.model;

import java.io.Serializable;

/**
 * @className DemoModel
 * @Description TODO
 * @Author zhaoteng
 * @Date 2019/8/2 17:25
 * @Version 1.0
 **/
public class DemoModel implements Serializable {

    private String id;

    private String num;

    private String username;

    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
