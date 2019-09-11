package com.example.springbootdemo.model;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @className EmployeeModel
 * @Description TODO
 * @Author zhaoteng
 * @Date 2019/8/30 13:43
 * @Version 1.0
 **/
public class EmployeeModel {

    private int id;

    private String name;

    private int age;

    private double salary;

    public EmployeeModel(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof EmployeeModel)) return false;

        EmployeeModel that = (EmployeeModel) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(age, that.age)
                .append(salary, that.salary)
                .append(name, that.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(age)
                .append(salary)
                .toHashCode();
    }
}
