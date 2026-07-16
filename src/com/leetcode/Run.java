package com.leetcode;

import com.leetcode.hashmap.CustomHashMap;
import com.leetcode.hashmap.RealHashMap;

public class Run {
    static void main(String[] args) {
//        CustomHashMap map = new CustomHashMap();
//
//        map.put("Apple","A red color fruit");
//        map.put("Mango","A Yellow color fruit");
//        map.put("Bomigranat","Ram's favaroute fruit");
//
//        System.out.println(map.get("Mango"));

        RealHashMap<Integer, String> hm = new RealHashMap<>();

        hm.put(1,"Ram");
        hm.put(2,"Ari");
        hm.put(3,"Pandi");
        hm.put(4,"Laksh");

        System.out.println(hm.containsKey(20));
    }
}
