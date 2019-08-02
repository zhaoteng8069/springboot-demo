package com.example.springbootdemo.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @className Runner
 * @Description TODO
 * @Author zhaoteng
 * @Date 2019/7/3 9:11
 * @Version 1.0
 **/
@Component
public class Runner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    @Override
    public void run(String... strings) throws Exception {

        System.out.println(" ... 任务执行 ... syso ...");
        LOGGER.info("。。。 任务执行 。。。 logger 。。。 ");

    }
}
