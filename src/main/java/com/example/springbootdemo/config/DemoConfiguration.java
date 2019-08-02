package com.example.springbootdemo.config;

import com.example.springbootdemo.model.DemoModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className DemoConfiguration
 * @Description 测试springboot注解
 * @Author zhaoteng
 * @Date 2019/8/2 17:06
 * @Version 1.0
 * @Desc
 *  @Conditional(TestCondition.class)
 *  这句代码可以标注在类上面，表示该类下面的所有@Bean都会启用配置，也可以标注在方法上面，只是对该方法启用配置。
 *
 *
 *
 * spring框架还提供了很多@Condition给我们用，当然总结用语哪种好理解，看给位读者喽
 *
 * @ConditionalOnBean（仅仅在当前上下文中存在某个对象时，才会实例化一个Bean）
 * @ConditionalOnClass（某个class位于类路径上，才会实例化一个Bean）
 * @ConditionalOnExpression（当表达式为true的时候，才会实例化一个Bean）
 * @ConditionalOnMissingBean（仅仅在当前上下文中不存在某个对象时，才会实例化一个Bean）
 * @ConditionalOnMissingClass（某个class类路径上不存在的时候，才会实例化一个Bean）
 * @ConditionalOnNotWebApplication（不是web应用）
 **/
@Configuration
@ConditionalOnProperty(prefix = "enable", name = "mybatis", havingValue = "1",matchIfMissing = true)
public class DemoConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoConfiguration.class);

    @Bean
    public DemoModel demoModel() {
        DemoModel model = new DemoModel();
        model.setId("1");
        LOGGER.info("###DemoModel创建成功！###");
        return model;
    }

}
