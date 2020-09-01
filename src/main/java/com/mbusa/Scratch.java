package com.mbusa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Scratch {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("c-class","g-class","a-class" );
        Set<String> set1 = new HashSet<>(list);
        System.out.println(set1);
        System.out.println(set1.contains("ss"));
    }
}
