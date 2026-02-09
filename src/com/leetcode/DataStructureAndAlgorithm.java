package com.leetcode;

class  FindTheCeilFromTheTarget{
//    what is ceil ?
//    The ceil is find the smallest element in the array that is greater than or equal to the target
//    is the ceil of the target

    static int findTheCeil(int[] arr,int target){
        int start=0;
        int end = arr.length-1;
        int mid=0;

        while(start<=end){
            mid= start + (end - start)/2;
            if(arr[mid]==target){
                return arr[mid];  //for index return mid
            }

            if(arr[mid]<target){
                start=mid+1;
            }else{
                end = mid -1;
            }

        }

        return arr[mid+=1]; //for index return mid+=1;

    }

}

public class DataStructureAndAlgorithm {
    static void main(String[] args) {
        int[] arr = {1,3,5,7,8,10,14};
        System.out.println(FindTheCeilFromTheTarget.findTheCeil(arr,6));
    }
}
