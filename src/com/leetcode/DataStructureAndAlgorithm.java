package com.leetcode;

import java.util.ArrayList;
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
class CycleSort{
    public static void cycleSort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct = arr[i] - 1;
            if(arr[i]!= arr[correct]){
                swap(arr,i, correct);
            }else{
                i++;
            }

        }
    }
    public static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
class Patterns{
    public static void pattern1(int n){
        for(int i=1;i<=n;i++){
            for(int j=1 ;j<=n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern2(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern3(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n+1 -i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern4(int n){
        for(int i=1;i<= n;i++){
            for (int j = 1; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void pattern5(int n){
        for (int i = 1; i <=(2*n) ; i++) {
            if ( i <= n){
                for (int j = 1; j <= i; j++) {
                    System.out.print("*" + " ");
                }
                System.out.println();
            }else {
                for (int j = 1; j <= (2*n - i); j++) {
                    System.out.print("*" + " ");
                }
                System.out.println();
            }
        }
    }
    public static void pattern6(int n){
        for (int row = 1; row <=n ; row++) {
            int noOfSpaces = n - row;
            for (int s = 1; s <=noOfSpaces ; s++) {
                System.out.print(" ");
            }

//            print *
            for (int col = 1; col <= row ; col++) {
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }
}
class Recursion{
    public static int fibonacci (int n){
        if(n < 2){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

}
class MathForDsa{
    public static boolean isOdd(int n){
        return  ((n & 1) == 1);
    }
    public static int findUnique(int[] arr){
        int ans =0;

        for (int n : arr){
            ans = ans ^ n;
        }

        return ans;
    }
    public static int findUnique(int[] arr,int times){
        int sum = 0;
        for(int n : arr){
            sum += n;
        }
        System.out.println("sum"+sum);
        int unique = sum % times;

        return unique;
    }//not find the answer I need to find the answer
    public static int findTheNthMagicNumber(int n){
        int ans = 0;
        int base = 5;

        while (n > 0){
            int last = n & 1;
            n = n>>1;
            ans += last * base;
            base = base * 5;
        }

        return ans;

    }
    public static int NoOfDigit(int n){
        int base = 10;
        int ans = (int)(Math.log(n) / Math.log(base)) + 1;
        return  ans;
    }
    public static boolean isPrime(int n){
        if(n <= 1){
            return false;
        }
        int c = 2;
        while (c * c <=n){
            if(n % c == 0){
                return false;
            }
            c++;
        }
        return true;
    }
    public static double sqrt(int n,int p){
        int start = 0;
        int end = n;
        double root = 0.0;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(mid * mid == n){
                return mid;
            }
            if(mid * mid > n){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        double incr = 0.1;
        for (int i = 0; i < p; i++) {
            while (root * root <= n){
                root+= incr;
            }
            root-= incr;
            incr /= 10;
        }
        return root;
    }
    public static double newtonSqrt(double n){
        double x = n;
        double root;

        while (true){
            root = 0.5 * (x + (n/x));

            if(Math.abs(root - x) < 0.1) {
                break;
            }
            x = root;
        }
        return root;
    }
    public static void factors1(int n){
        for(int i = 1; i <= n;i++){
            if(n % i == 0){
                System.out.print(i + " ");
            }
        }
    }
    public static void factors2(int n){
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n % i  == 0){
                if(i == n/i){
                    System.out.println(i);
                }else{
                    System.out.print(i + " ");
                    list.add(n/i);
                }
            }
        }
        for(int i=list.size()-1 ;i>=0;i--){
            System.out.print(list.get(i) + " ");
        }
    }
    public static int HCF(int a,int b){
        if( a == 0){
            return b;
        }
        return HCF(b%a,a);
    }
    public static int LCM(int a,int b){
        return a*b / HCF(a,b);
    }
}
class Recursion2{
    public static int printNum(int n){
        if(n == 1){
            return 1;
        }
        System.out.println(n);
        return printNum(n-1);
    }
    public static void printNumRev(int n){
        if(n == 0){
            return;
        }

        printNumRev(n-1);
        System.out.println(n);
    }
    public static void printNumBoth(int n){
        if( n == 0){
            return;
        }
        System.out.println(n);
        printNumBoth(n-1);
        System.out.println(n);
    }
    public static int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }
    public static int sumOfSeries(int n){
        if( n == 1 ) return 1;
        return n + sumOfSeries(n-1);
    }
    public static int sumOfDigit(int n){
        if( n == 0){
            return 0;
        }
        return (n%10) + sumOfDigit(n/10);
    }
    public static int productOfDigit(int n){
        if(n % 10 == n){
            return n;
        }
        return (n % 10) * productOfDigit(n / 10);
    }
}

class Revision{
    static int[] reverseArray(int[] arr){
        for(int i=0;i<arr.length / 2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length -1 -i];
            arr[arr.length -1 -i] = temp;
        }
        return arr;
    }
}

public class DataStructureAndAlgorithm {
    static void main(String[] args)  {
//        int[] arr = {8,10,11,12,15,16,17,18,20,22,30,32,34,37,40,50,56,58,60,62,64,66,69,70,72,79,80,82,84,86,87,88,89,90};
//        System.out.println(FindTheFloorFromTheTarget.findTheFloor(arr,9));
//        System.out.println(FindTheTargetFromInfinityArray.ans(arr,41));
//        int arr[][] = {{10,20,30,40},{15,25,35,45},{28,29,37,49},{33,34,38,50}};
//        System.out.println(Arrays.toString(FindTheTargetFrom2DArray.findTheTargetFrom2DArray(arr,49)));
//          int arr[] = { 2,2,3,2,7,7,8,7,8,8,};
//        BubbleSort.bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
//          SelectionSort.selectionSort(arr);
//          InsertionSort.insertionSort(arr);
//          System.out.println(Arrays.toString(arr));
//        CycleSort.cycleSort(arr);
//        System.out.println(Arrays.toString(arr));
//        Patterns p = new Patterns();
//        p.pattern6(5);

//        System.out.println(MathForDsa.findUnique(arr,3));
//        System.out.println(MathForDsa.findTheNthMagicNumber(3));

//        System.out.println(MathForDsa.NoOfDigit(385738959));
//        int[] arr = {1,1,1,0};
//         System.out.println(Arrays.toString(Revision.reverseArray(arr)));
//        for (int i = 0; i <= 40; i++) {
//            if(MathForDsa.isPrime(i)){
//                System.out.println(i);
//            }
//         System.out.println(i + " " + MathForDsa.isPrime(i));
//        }
//        System.out.printf("%.3f",MathForDsa.sqrt(40,3));
//        System.out.println();
//        System.out.println(MathForDsa.newtonSqrt(40));
//        MathForDsa.factors2(20);

//        Recursion2.printNumBoth(5);
//        System.out.println(Recursion2.sumOfSeries(5));

        System.out.println(Recursion2.sumOfDigit(1956));
        System.out.println(Recursion2.productOfDigit(14));
    }
}
