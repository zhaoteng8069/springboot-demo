package com.example.springbootdemo;

import com.example.springbootdemo.util.BinaryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @className Commland
 * @Description TODO
 * @Author zhaoteng
 * @Date 2019/8/9 15:41
 * @Version 1.0
 **/
/*@Component*/
public class Commland implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(Commland.class);
    @Override
    public void run(String... strings) throws Exception {
        try {
            BinaryUtil.error();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("##############ooooo##################");
        BinaryUtil.error();
    }
}
