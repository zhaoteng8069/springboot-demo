package com.example.springbootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootDemoApplicationTests.class);

    @Test
    public void contextLoads() {

        LOGGER.info("hello world ... ");

    }

}
