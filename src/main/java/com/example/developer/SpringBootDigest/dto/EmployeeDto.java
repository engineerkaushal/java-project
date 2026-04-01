package com.example.developer.SpringBootDigest.dto;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class EmployeeDto {
    private Integer id;
    private String name;
    private String dep;
    private Double salary;
    private Integer age;
    private List<String> skills;

    public EmployeeDto (Integer id, String name, String dep, Double salary, Integer age, List<String> skills) {
        this.id = id;
        this.name = name;
        this.dep = dep;
        this.salary = salary;
        this.age = age;
        this.skills = skills;
    }

    public
    Integer getId () {
        return id;
    }

    public
    String getName () {
        return name;
    }

    public
    String getDep () {
        return dep;
    }

    public
    Double getSalary () {
        return salary;
    }

    public
    Integer getAge () {
        return age;
    }

    public
    List<String> getSkills () {
        return skills;
    }

    @Override
    public
    String toString () {
        return "EmployeeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dep='" + dep + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", skills=" + skills +
                '}';
    }

    public static List<EmployeeDto> getEmployeeData() {
        return Arrays.asList (
                new EmployeeDto (1, "Kaushal", "IT", 100000.0, 31, Arrays.asList ("Java", "Sql")),
                new EmployeeDto (2, "Saurabh", "IT", 95000.0, 25, Arrays.asList ("Java", "SQL")),
                new EmployeeDto (3, "Abhishek", "QA", 94500.0, 30, Arrays.asList ("Junit")),
                new EmployeeDto (4, "Shivani", "HR", 88000.0, 29, Arrays.asList ()),
                new EmployeeDto (5, "Ragini", "HR", 78000.0, 29, Arrays.asList ()),
                new EmployeeDto (6, "Rajan", "BA", 56000.0, 32, Arrays.asList ()),
                new EmployeeDto (7, "Mukul", "BA", 98000.0, 28, Arrays.asList ()),
                new EmployeeDto (8, "Rama", "QA", 110000.0, 45, Arrays.asList ("Testing")),
                new EmployeeDto (9, "Kaushal", "DevOps", 105000.0, 29, Arrays.asList ()),
                new EmployeeDto (10, "Sunny", "DevOps", 99500.0, 30, Arrays.asList ())
        );
    }
}

