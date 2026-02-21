package com.leetcode;

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

public class DataStructureAndAlgorithm {
    static void main(String[] args)  {
//        int[] arr = {8,10,11,12,15,16,17,18,20,22,30,32,34,37,40,50,56,58,60,62,64,66,69,70,72,79,80,82,84,86,87,88,89,90};
//        System.out.println(FindTheFloorFromTheTarget.findTheFloor(arr,9));
//        System.out.println(FindTheTargetFromInfinityArray.ans(arr,41));
        int arr[] = {3,5,1};
        System.out.println(FindTheTargetFromRotatedSortedArray.search(arr,3));


    }
}
