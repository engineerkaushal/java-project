package com.example.developer.SpringBootDigest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test1 {
    public static void main (String[] args) {

        //["java", "is", "fun", "spring"]

        //2 -> [is]

        //3 -> [fun]

        //4 -> [java]

        //6 -> [spring]

        //Group words based on their length.Group words based on their length.

        List<String> input = Arrays.asList ("java", "is", "is", "fun", "spring");

        Map<String, Integer> longMap = input.stream ( )
                .collect (Collectors.toMap (ele -> ele, String::length, (a, b) -> a, TreeMap::new));

        System.out.println (longMap );


    }

}
