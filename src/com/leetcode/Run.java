package com.leetcode;

import com.leetcode.hashmap.CustomHashMap;

public class Run {
    static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();

        map.put("Apple","A red color fruit");
        map.put("Mango","A Yellow color fruit");
        map.put("Bomigranat","Ram's favaroute fruit");

        System.out.println(map.get("Mango"));
    }
}
