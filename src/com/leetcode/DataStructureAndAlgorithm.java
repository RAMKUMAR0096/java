package com.leetcode;

import java.util.Arrays;

class  FindTheCeilFromTheTarget{
//    what is ceil ?
//    The ceil is find the smallest element in the array that is greater than or equal to the target
//    is the ceil of the target

    static int findTheCeil(int[] arr,int target){
        int start=0;
        int end = arr.length-1;
        System.out.println("Start: "+start+"End: "+end);
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

       return arr[start]; //for index return mid+=1;

    }

}
class  FindTheFloorFromTheTarget{
//    what is floor ?
//    The floor is find the biggest element in the array that is lower than or equal to the target
//    is the floor of the target

    static int findTheFloor(int[] arr,int target){
        int start=0;
        int end = arr.length-1;
        System.out.println("Start: "+start+"End: "+end);
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

        System.out.println("Start: "+start+"End: "+end);

        return arr[end]; //for index return mid+=1;

    }

}
class FindTheTargetFromInfinityArray{

    static int ans(int arr[],int target){
        int start = 0;
        int end =1;

        while (target >arr[end]){
            int temp = end +1;
             end = end + (end - start + 1) * 2;
             start = temp;
        }
        return binarySearch(arr,target,start,end);
    }

    static int binarySearch(int arr[],int target,int start,int end){

        while(start<=end){
            int mid = start + (end-start)/2;
            if(target<arr[mid]){
                end = end-1;
            } else if (target >arr[mid]) {
                start = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
class FindThePeakElementInTheMountain{
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
class FindTheTargetFromRotatedSortedArray{
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
class FindTheTargetFrom2DArray{
    static public int[] findTheTargetFrom2DArray(int[][] arr, int target){
//        for(int i=0;i<arr.length;i++){
//            for(int j=i;j<arr.length;j++){
//                if(arr[i][j] == target){
//                    return arr[i][j];
//                }
//            }
//        }
        int r = 0;
        int c = arr.length -1;
        while (r < arr.length && c >= 0){
            if(arr[r][c] == target){
                return new int[]{r,c};
            }
            if(arr[r][c] < target){
                r++;
            }else {
                c--;
            }
        }
        return new int[]{-1,-1};
    }
}
class BubbleSort{
    static public void bubbleSort(int[] arr){
        for(int i=0; i < arr.length; i++){
            boolean isSwaped = false;
            for(int j=1;j<arr.length - i;j++){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    isSwaped = true;
                }
            }
            if(!isSwaped){
                break;
            }
        }
    }
}
class SelectionSort{
    public static void selectionSort(int[] arr){
        for(int i = 0;i < arr.length ; i++){
            int last = arr.length -i -1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex,last);
        }
    }
    public static int getMaxIndex(int[] arr,int start,int end){
        int max = start;
        for(int i=0;i<end;i++){
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }
    public static void swap(int[] arr, int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
class InsertionSort{
    public static void insertionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j > 0;j--){
                if(arr[j]>arr[j-1]){
                    break;
                }else {
                    swap(arr,j,j-1);
                }
            }
        }
    }
    public static void swap(int[] arr,int first,int second){
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second] = temp;
    }
}

public class DataStructureAndAlgorithm {
    static void main(String[] args)  {
//        int[] arr = {8,10,11,12,15,16,17,18,20,22,30,32,34,37,40,50,56,58,60,62,64,66,69,70,72,79,80,82,84,86,87,88,89,90};
//        System.out.println(FindTheFloorFromTheTarget.findTheFloor(arr,9));
//        System.out.println(FindTheTargetFromInfinityArray.ans(arr,41));
//        int arr[][] = {{10,20,30,40},{15,25,35,45},{28,29,37,49},{33,34,38,50}};
//        System.out.println(Arrays.toString(FindTheTargetFrom2DArray.findTheTargetFrom2DArray(arr,49)));
          int arr[] = { 3,56,7,9,5,1,2,700,56,49};
//        BubbleSort.bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
//          SelectionSort.selectionSort(arr);
          InsertionSort.insertionSort(arr);
          System.out.println(Arrays.toString(arr));


    }
}
