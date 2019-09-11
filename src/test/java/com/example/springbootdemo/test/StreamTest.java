package com.example.springbootdemo.test;

import com.example.springbootdemo.model.Employee2Model;
import com.example.springbootdemo.model.EmployeeModel;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @className StreamTest
 * @Description TODO
 * @Author zhaoteng
 * @Date 2019/9/11 11:35
 * @Version 1.0
 **/
public class StreamTest {

    private List<EmployeeModel> emps;

    private List<Employee2Model> emp2s;

    @Test

    public void test1() {
        Stream<String> stream = Stream.of("1", "3", "4");
        stream.forEach(System.out::println);
    }

    @Test
    public void test2() {
        // 创建无限流
        // TODO LAMBDA表达式存在问题
        Stream<Integer> stream = Stream.iterate(0, (x) -> x + 2);
        stream.limit(10).forEach(System.out::println);
    }

    @Test
    public void test3() {
        // 创建无限流
        Stream.generate(() -> Math.random()).limit(5).forEach(System.out::println);
    }

    @Before
    public void init() {
        // 中间操作
        emps = Arrays.asList(
                new EmployeeModel(102, "李四", 59, 6666.66),
                new EmployeeModel(101, "张三", 18, 9999.99),
                new EmployeeModel(103, "王五", 28, 3333.33),
                new EmployeeModel(104, "赵六", 8, 7777.77),
                new EmployeeModel(104, "赵六", 8, 7777.77),
                new EmployeeModel(104, "赵六", 8, 7777.77),
                new EmployeeModel(105, "田七", 38, 5555.55));

        emp2s = Arrays.asList(
                new Employee2Model(102, "李四", 59, 6666.66, Employee2Model.Status.BUSY),
                new Employee2Model(101, "张三", 18, 9999.99, Employee2Model.Status.FREE),
                new Employee2Model(103, "王五", 28, 3333.33, Employee2Model.Status.VOCATION),
                new Employee2Model(104, "赵六", 8, 7777.77, Employee2Model.Status.BUSY),
                new Employee2Model(104, "赵六", 8, 7777.77, Employee2Model.Status.FREE),
                new Employee2Model(104, "赵六", 8, 7777.77, Employee2Model.Status.FREE),
                new Employee2Model(105, "田七", 38, 5555.55, Employee2Model.Status.BUSY)
        );
    }

    @Test
    public void test4() {
        // 中间操作 filter，从流中排除某些元素
        // 多个中间操作可以连起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会处理任何请求
        // 当触发终止操作时，一次性全部处理，称为“惰性求值”
        emps.stream()
                .filter((e) -> e.getAge() > 18) // 中间操作
                .forEach(System.out::println); //终止操作
    }

    @Test
    public void test5() {
        // 中间操作 limit
        // 这种"."式操作很有意思，可以一直"."，直到得到你想要的
        emps.stream().filter((m) -> m.getAge() > 8).limit(4).forEach(System.out::println);
    }

    @Test
    public void test6() {
        // 中间操作skip
        emps.stream().filter((x) -> x.getAge() > 8).skip(4).forEach(System.out::println);
    }

    @Test
    public void test7() {
        // 中间操作 distinct
        // 通过对象的hasCode和equals来去重，所以对象要重写这两个方法
        emps.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void test8() {
        // 中间操作 - 映射
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);

        System.out.println("-----------------------------------------");

        emps.stream().map(EmployeeModel::getName).forEach(System.out::println);
    }

    @Test
    public void test9() {
        // 中间操作 - 排序
        List<String> list = Arrays.asList("fff", "bbb", "aaa", "eee");
        list.stream().sorted().forEach(System.out::println);

        System.out.println("==================定制排序=======================");
        emps.stream().sorted((x, y) -> {
            if (x.getAge() == y.getAge()) {
                return x.getName().compareTo(y.getName());
            } else {
                return Integer.compare(x.getAge(), y.getAge());
            }
        }).forEach(System.out::println);
    }

    /****************************************终止操作********************************/
    @Test
    public void test10() {
        // 终止操作 - allMatch - 匹配所有元素
        boolean flag = emp2s.stream().allMatch((e) -> e.getStatus().equals(Employee2Model.Status.BUSY));
        System.out.println(String.format("~~~%s~~~~", flag));
    }

    @Test
    public void test11() {
        // 终止操作 - anyMatch - 匹配任意一个元素
        boolean flag = emp2s.stream().anyMatch((e) -> e.getStatus().equals(Employee2Model.Status.BUSY));
        System.out.println(String.format("~~~%s~~~~", flag));
    }

    @Test
    public void test12() {
        // 终止操作 - noneMatch - 没有匹配元素
        boolean flag = emp2s.stream().noneMatch((e) -> e.getStatus().equals(Employee2Model.Status.BUSY));
        System.out.println(String.format("~~~%s~~~~", flag));
    }

    @Test
    public void test13() {
        // 终止操作 - noneMatch - 没有匹配元素，还有一些别的，不再一一赘述
        Optional<Employee2Model> first = emp2s.stream().sorted((x, y) -> {
            return Double.compare(x.getSalary(), y.getSalary());
        }).findFirst();

        System.out.println(String.format("~~~%s~~~~", first));
    }

    /******************************************归约*************************************/
    @Test
    public void test14() {
        // 规约
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 6);
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        Optional<Double> reduce1 = emp2s.stream().map(Employee2Model::getSalary).reduce(Double::sum);
        System.out.println(reduce1);
    }

    /***************************************收集****************************************/
    @Test
    public void test15() {
        List<String> list = emp2s.stream().map(Employee2Model::getName).collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    @Test
    public void test16() {
        Optional<Double> collect = emp2s.stream().map(Employee2Model::getSalary).collect(Collectors.maxBy(Double::compareTo));
        System.out.println(collect.get());
    }

    /*************************************分组****************************************/
    @Test
    public void test17() {
        Map<Employee2Model.Status, List<Employee2Model>> collect = emp2s.stream().collect(Collectors.groupingBy(Employee2Model::getStatus));
        System.out.println(collect);
    }

    @Test
    public void test18() {
        Map<Employee2Model.Status, Map<String, List<Employee2Model>>> collect = emp2s.stream().collect(Collectors.groupingBy(Employee2Model::getStatus, Collectors.groupingBy((e) -> {
            if (e.getAge() > 60) {
                return "老年";
            } else if (e.getAge() >= 35) {
                return "中年";
            } else {
                return "成年";
            }
        })));
        System.out.println(collect);
    }

    /**************************************组接字符串**********************************************/
    @Test
    public void test19() {
        String collect = emp2s.stream().map(Employee2Model::getName).collect(Collectors.joining(","));
        System.out.println(collect);
    }

    @Test
    public void test20() {
        String collect = emp2s.stream().map(Employee2Model::getName).collect(Collectors.joining(",","pre","fix"));
        System.out.println(collect);
    }
}
