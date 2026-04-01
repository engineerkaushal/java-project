package com.example.developer.SpringBootDigest;


import com.example.developer.SpringBootDigest.dto.EmployeeDto;
import io.micrometer.common.util.StringUtils;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main (String[] args) {

        List<EmployeeDto> empList = EmployeeDto.getEmployeeData ( );

        Map<String, Double> doubleMap = empList.stream ( )
                .filter (f -> !StringUtils.isBlank (f.getDep ( ))
                        && f.getSalary ( ) != 0)
                .collect (Collectors.groupingBy (EmployeeDto::getDep,
                        Collectors.averagingDouble (EmployeeDto::getSalary)));
        System.out.println ("UnSorted map : " + doubleMap );

        LinkedHashMap<String, Double> collect = empList.stream ( )
                .filter (f -> !StringUtils.isBlank (f.getDep ( ))
                        && f.getSalary ( ) != 0)
                .collect (Collectors.groupingBy (EmployeeDto::getDep,
                        Collectors.averagingDouble (EmployeeDto::getSalary)))
                .entrySet ( ).stream ( ).sorted (Map.Entry.<String, Double>comparingByValue ( Comparator.reverseOrder ())
                        .thenComparing (Map.Entry.comparingByKey ())).collect (Collectors.toMap (
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> b,
                        LinkedHashMap::new
                ));

        System.out.println ("Sorted map : " + collect );

        List<Map.Entry<String, Double>> list = empList.stream ( )
                .filter (f -> !StringUtils.isBlank (f.getDep ( ))
                        && f.getSalary ( ) != 0)
                .collect (Collectors.groupingBy (EmployeeDto::getDep,
                        Collectors.averagingDouble (EmployeeDto::getSalary)))
                .entrySet ( ).stream ( ).sorted (Map.Entry.<String, Double>comparingByValue ( ).reversed ( ))
                .collect (Collectors.toMap (
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> b,
                        LinkedHashMap::new
                )).entrySet ( ).stream ( ).skip (1).limit (2).toList ( );

        System.out.println (list );

    }
}
