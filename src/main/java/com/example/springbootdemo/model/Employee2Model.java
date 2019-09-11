package com.example.springbootdemo.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @className Employee2Model
 * @Description TODO
 * @Author zhaoteng
 * @Date 2019/9/11 15:23
 * @Version 1.0
 **/
public class Employee2Model {

    private int id;
    private String name;
    private int age;
    private double salary;
    private Status status;

    public enum Status {
        FREE,BUSY, VOCATION;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Employee2Model(int id, String name, int age, double salary, Status status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Employee2Model)) return false;

        Employee2Model that = (Employee2Model) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(age, that.age)
                .append(salary, that.salary)
                .append(name, that.name)
                .append(status, that.status)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(age)
                .append(salary)
                .append(status)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Employee2Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }
}
