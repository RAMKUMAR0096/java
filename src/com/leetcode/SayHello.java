package com.leetcode;

import com.leetcode.heap.Heap;

import java.sql.Array;
import java.util.*;
import java.util.function.BiConsumer;

public class SayHello {

    static int digitalRoot(int n){
        if(n== 0){
            return 0;
        }
        return (n % 9 == 0) ? 9 : n % 9;
    }

    static int findSumOfDight(int input){

        while (input >= 10){
            int output = 0;
            while (input > 0){
                int rem = input % 10;
                output = output + rem;
                input /= 10;
            }

            input = output;
        }


        return input;
    }

    public static void main(String[] args) throws Exception {

//        Map<Integer, List<Integer>> ans = adj();
        adjList().forEach((k, v) ->System.out.println(k + " : " + v));
        matrix();


    }

    public static Map<Integer, List<Integer>> adjList(){
        int[][] edge = {
                {1,2}, {1,4},{2,3},{2, 4}, {3, 5},{4, 5}
        };
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 1; i < 6; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] e : edge){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return adj;
    }

    public static void matrix(){
        int[][] mat = new int[6][6];
        int[][] edge = {
                {1,2}, {1,4},{2,3},{2, 4}, {3, 5},{4, 5}
        };
        for(int[]e : edge){
            mat[e[0]][e[1]] = 1;
            mat[e[1]][e[0]] = 1;
        }


        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                System.out.print(mat[i][j] + " ");;
            }
            System.out.println();
        }
    }


}
