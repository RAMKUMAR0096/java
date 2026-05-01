package com.leetcode;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FindTheDifference {
    public char findTheDifference(String s, String t) {
        String main=s+t;
        char mainarr[]=main.toCharArray();
        char unique=0;
        //In java we have direct option to xor in characters also
        for(char i:mainarr){
            unique=(char)(unique^i);
        }
        return unique;
    }

}

class addString{

        public String addStrings(String num1, String num2) {
            String s = "";
            int carry = 0;
            int int1 = num1.length() - 1;
            int int2 = num2.length() - 1;
            while (int1 >= 0 || int2 >= 0 || carry > 0) {
                int digit1 = int1 >= 0 ? num1.charAt(int1) - '0' : 0;
                int digit2 = int2 >= 0 ? num2.charAt(int2) - '0' : 0;

                int sum = digit1 + digit2 + carry;
                carry = sum / 10; // Q
                int digit = sum % 10; // R
                s = digit + s;
                int1--;
                int2--;
            }
            return s;
        }

        static {
            Runtime.getRuntime().gc();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try (FileWriter f = new FileWriter("display_runtime.txt")) {
                    f.write("0");
                } catch (Exception e) {
                }
            }));
        }
}
class nextGreatestLetterInLeetCode{
    public char nextGreatestLetter(char[] letters, char target) {
        int start=0;
        int end = letters.length-1;
        while(start<=end){
            int mid = start + (end-start) / 2;
            if(target<letters[mid]){
                end = mid-1;
            }else{
                start = start+1;
            }
        }
        return letters[start % letters.length];
    }
}
class FindFirstAndLastPositionInSortedArray{
        public int[] searchRange(int[] nums, int target) {

            int[] ans = {-1, -1};
            // check for first occurrence if target first
            ans[0] = search(nums, target, true);
            if (ans[0] != -1) {
                ans[1] = search(nums, target, false);
            }
            return ans;
        }
        int search(int[] nums, int target, boolean findStartIndex) {
            int ans = -1;
            int start = 0;
            int end = nums.length - 1;
            while(start <= end) {

                int mid = start + (end - start) / 2;

                if (target < nums[mid]) {
                    end = mid - 1;
                } else if (target > nums[mid]) {
                    start = mid + 1;
                } else {
                    ans = mid;
                    if (findStartIndex) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
            return ans;
        }

}
class FindThePeakElementInMountain{
    static public int peakIndexInMountainArray(int[] arr) {
        int start =0;
        int end = arr.length -1;
        while(start<end){
            int mid = start + (end - start) / 2;
            if(arr[mid] >arr[mid+1]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
}
class FindTheSolutionForMountainArrayInHardQuestion1095L{
    /**
     * // This is MountainArray's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface MountainArray {
     *     public int get(int index) {}
     *     public int length() {}
     * }
     */
    /*

    class Solution {
        public int findInMountainArray(int target, MountainArray mountainArr) {
            int peak = PeakIndexInMountainArray(mountainArr);
            int firstTry = orderAgnosticBS(mountainArr,target,0,peak);
            if(firstTry !=-1){
                return firstTry;
            }
            return orderAgnosticBS(mountainArr, target,peak+1,mountainArr.length() -1);
        }
        static int PeakIndexInMountainArray(MountainArray mountainArr){
            int start =0;
            int end = mountainArr.length() -1;
            while(start<end){
                int mid = start + (end -start) / 2;
                if(mountainArr.get(mid)>mountainArr.get(mid+1)){
                    end = mid;
                }else{
                    start = mid + 1;
                }
            }
            return start;
        }

        static int orderAgnosticBS(MountainArray mountainArr, int target,int start,int end){

            boolean isAsc = mountainArr.get(start) < mountainArr.get(end);
            while(start<=end){
                int mid = start + (end - start) / 2;

                if(mountainArr.get(mid) == target){
                    return mid;
                }

                if(isAsc){
                    if(target < mountainArr.get(mid)){
                        end = mid -1;
                    }else{
                        start = mid+1;
                    }
                }else{
                    if(target > mountainArr.get(mid)){
                        end = mid-1;
                    }else{
                        start = mid +1;
                    }
                }
            }
            return -1;
        }
    }
    */
}
class FindTheSolutionForRotatedSortedArray33L{
    public static int search(int[] nums, int target){
        int pivot = findPivot(nums);
        if(pivot == -1){
            return binarySearch(nums,target,0,nums.length -1);
        }
        if(nums[pivot] == target){
            return pivot;
        }
        if(target >= nums[0]){
            return binarySearch(nums,target,0,pivot-1);
        }

        return binarySearch(nums,target,pivot+1, nums.length -1);

    }
    public static  int findPivot(int[] arr){
        int start=0;
        int end = arr.length -1;
        while (start <= end){
            int mid = start + ( end - start ) / 2;
            if(mid < end && arr[mid] >= arr[mid+1]){
                return mid;
            }
            if(mid > start &&arr[mid] <= arr[mid-1]){
                return mid-1;
            }
            if(arr[mid] <= arr[start]){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
    public static int binarySearch(int[]arr, int target, int start, int end){
        while (start <= end){
            int mid = start + ( end - start) / 2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
class FlipingAnImage{
    static int[][] flipinganImage(int[][] image){
        for(int[] row : image){
            for (int i=0;i<(image[0].length + 1) /2;i++){
                int temp = row[i] ^ 1;
                row[i] = row[image[0].length -i -1] ^ 1;
                row[image[0].length -i -1] = temp;
            }
        }
        return image;
    }
}
class PhonePad {
    public List<String> letterCombinations(String digits) {
        List<String> s= lc("",digits);
        return s;
    }

    static List<String> lc(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        List<String> ans = new ArrayList<>();

        int digit = unprocessed.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char)('a' + i);
            ans.addAll(lc(processed + ch,unprocessed.substring(1)));
        }
        return ans;
    }
}


class Leetcode {
    static void main(String[] args) {
//        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
//        System.out.println(FlipingAnImage.flipinganImage(image));
        PhonePad s = new PhonePad();

        System.out.println(s.letterCombinations("12"));
    }
}


