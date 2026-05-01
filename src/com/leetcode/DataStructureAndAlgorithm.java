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
    public static void myreverseNumber(int n){
        ArrayList<Integer> list = new ArrayList<>();

        while (n > 0){
            int last = n % 10;
            list.add(last);
            n /= 10;
        }


        for (int i = 0; i< list.size();i++){
            System.out.println(list.get(i));
        }


    }
    static int s = 0;
    public static void reverseNumberusingOneVariable(int n){
        if( n == 0) return;
        int digit = n % 10;
        s = s * 10 + digit;
        reverseNumberusingOneVariable(n/10);

    }
    public static int recerseNum(int n){
        int digit = (int)(Math.log10(n)) + 1;
        return helper(n, digit);
    }
    private static int helper(int n, int digit) {
        if( n % 10 == n){
            return n;
        }
        int rem = n % 10;

        return rem * (int)(Math.pow(10,digit -1)) + helper(n/10,digit - 1);
    }
    public static int countZeroFromTheGivenNumber(int n){
        int count =0;
        return helpeer(n,count);
    }
    private static int helpeer(int n,int count){
        if(n == 0) return count;
        int rem = n % 10;
        if(rem == 0){
            return helpeer(n/10,count+=1);
        }
        return helpeer(n/10,count);
    }
}
class RecursionInArray{
    public static boolean isSorted(int[] arr,int index){
        if(index == arr.length -1){
            return true;
        }
        return arr[index] < arr[index + 1] && isSorted(arr,index+1);
    }
    public static boolean findTheTargetUsingLinearSearch(int[] arr, int target,int index){
        if(index == arr.length){
            return false;
        }
        if(arr[index] == target){
            return true;
        }

        return findTheTargetUsingLinearSearch(arr,target,index+1);
    }
    public static int findTheTargetUsingLinearSearchAndReturnTheIndex(int[] arr, int target,int index){
        if(index == arr.length){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }
        return findTheTargetUsingLinearSearchAndReturnTheIndex(arr,target,index+1);
    }
    public static int findTheTargetFromLastUsingLinearSearchAndReturnTheIndex(int[] arr,int target,int index){
        if(index == -1){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }
        return findTheTargetFromLastUsingLinearSearchAndReturnTheIndex(arr,target,index-1);
    }
    public static ArrayList<Integer> findTheTargetUsingLinearSearchAndReturnTheArrayList(int[] arr,int target,int index,ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        return findTheTargetUsingLinearSearchAndReturnTheArrayList(arr,target,index + 1,list);
    }
    public static ArrayList<Integer> findTheTargetUsingLinearSearchAndReturnTheArrayListWithoutPassingTheArguments(int[] arr,int target,int index){

        ArrayList<Integer> list = new ArrayList<>();

        if(index == arr.length){
            return new ArrayList<>();
        }

        if(arr[index] == target){
            list.add(index);
        }
        ArrayList<Integer> answerFromBelowCalls = findTheTargetUsingLinearSearchAndReturnTheArrayListWithoutPassingTheArguments(arr, target,index+1);

        list.addAll(answerFromBelowCalls);

        return list;

    }
    public static  int rotatedBinarySearch(int[] arr, int target,int s,int e){
        if(s > e){
            return -1;
        }
        int m = s + (e - s) / 2;
        if(arr[m] == target){
            return m;
        }
        if(arr[s] <= arr[m]){
            if(target <= arr[m] && arr[s] <= target){
                return rotatedBinarySearch(arr,target,s,m-1);
            }
            else {
                return rotatedBinarySearch(arr,target,m+1,e);
            }
        }

        if (target >= arr[m] && target <= arr[e]){
            return rotatedBinarySearch(arr,target,m + 1,e);
        }
        else {
            return rotatedBinarySearch(arr,target,s,m-1);
        }

    }
}
class PatternUsingRecursion{
    public static void pattern(int r,int c){
        if(r == 0){
            return;
        }
        if(r > c){
            System.out.print('*' + " ");
            pattern(r,c + 1);
        }else {
            System.out.println();
            pattern(r-1,0);
        }
    }
    public static void pattern2(int r,int c){
        if(r == 0){
            return;
        }
        if(r > c){
            pattern2(r,c + 1);
            System.out.print('*'+ " ");
        }else {
            pattern2(r-1,0);
            System.out.println();



        }
    }
    public static void bubbleSort(int[] arr, int first, int last){
        if(last == 0){
            return;
        }
        if( first < last){
            if(arr[first] > arr[first + 1]){
                int temp = arr[first];
                arr[first] = arr[first + 1];
                arr[first + 1] = temp;
            }
            bubbleSort(arr,first+1,last);
        }else {
            bubbleSort(arr,0,last -1);
        }
    }
    public static void selectionSort(int[] arr, int first, int last, int max){
        if(last == 0){
            return;
        }
        if(first < last){
            if(arr[first] > arr[max]){
                selectionSort(arr,first+1,last,first);
            }else {
                selectionSort(arr,first + 1,last,max);
            }
        }else {
            int temp = arr[max];
            arr[max] = arr[last-1];
            arr[last -1] = temp;
            selectionSort(arr,0,last-1,0);
        }
    }
}
class MergeSort{
    public static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(right,left);
    }
    private static int[] merge(int[] right, int[] left) {
        int[] mix = new int[right.length + left.length];

        int i = 0;
        int j = 0;
        int k = 0;


        while (i < left.length && j < right.length){
            if(left[i] < right[j]){
                mix[k] = left[i];
                i++;
            }else{
                mix[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length){
            mix[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length){
            mix[k] = right[j];
            j++;
            k++;
        }

        return mix;
    }
    public static void mergeSortInPlace(int[] arr , int start, int end){
        if(end - start == 1){
            return;
        }
        int mid = start + (end - start) / 2;

        mergeSortInPlace(arr,start, mid);
        mergeSortInPlace(arr,mid,end);

        mergeInPlace(arr,start,mid,end);
    }
    private static void mergeInPlace(int[] arr, int start,int mid,int end) {
        int[] mix = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;


        while (i < mid && j < end){
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            }else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid){
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < end){
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[start+l] = mix[l];
        }
    }
}
class QuickSort{
    public static void quickSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int start = low;
        int end = high;
        int mid = start+ (end - start) / 2;
        int pivot = arr[mid];
        while (start <= end){
            while (arr[start] < pivot){
                start++;
            }
            while (arr[end] > pivot){
                end--;
            }
            if(start <= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(arr,low,end);
        quickSort(arr, start,high);
    }
}
class StringUsingRecursion{
    public static String skipA(String s){
        if(s.isEmpty()){
            return "";
        }
        if(s.charAt(0) == 'a'){
            return skipA(s.substring(1));
        }else {
            return s.charAt(0) + skipA(s.substring(1));
        }
    }
    public static void SkipAInPlace(String p, String s){
        if(s.isEmpty()){
            System.out.println(p);
            return;
        }
        if (s.charAt(0) == 'a') {
            SkipAInPlace(p,s.substring(1));
        }else {
            SkipAInPlace(p+s.charAt(0),s.substring(1));
        }
    }
    public static String skipAppNotApple(String s){
        if(s.isEmpty()){
            return "";
        }
        if(s.startsWith("app") && !s.startsWith("apple")){
            return skipAppNotApple(s.substring(3));
        }else {
            return s.charAt(0) + skipAppNotApple(s.substring(1));
        }
    }
    public static void subSequence(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        subSequence(processed + unprocessed.charAt(0),unprocessed.substring(1));
        subSequence(processed,unprocessed.substring(1));
    }
    public static ArrayList<String> subSequenceInArrayList(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        ArrayList<String> left = subSequenceInArrayList(processed + unprocessed.charAt(0),unprocessed.substring(1));
        ArrayList<String> right = subSequenceInArrayList(processed,unprocessed.substring(1));

        left.addAll(right);
        return left;
    }
}
class Dice{
    public static void makeDice(String processed, int target){
        if(target == 0){
            System.out.println(processed);
            return;
        }
        for (int i = 1; i< 6 && i <= target;i++){
            makeDice(processed + i, target - i);
        }
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

//        System.out.println(Recursion2.sumOfDigit(1956));
//        System.out.println(Recursion2.productOfDigit(14));
//        Recursion2.reverseNumberusingOneVariable(123);
//        System.out.println(Recursion2.s);
//        System.out.println(Recursion2.recerseNum(12340));
//        System.out.println(Recursion2.countZeroFromTheGivenNumber(1000004005));
//        int[] arr = { 85,45,23,56,78,43,25,75,44};
//        System.out.println(RecursionInArray.findTheTargetUsingLinearSearch(arr,4,0));
//        System.out.println(RecursionInArray.findTheTargetUsingLinearSearchAndReturnTheIndex(arr,4,0));
//        System.out.println(RecursionInArray.findTheTargetFromLastUsingLinearSearchAndReturnTheIndex(arr,4,arr.length-1));
//        System.out.println(RecursionInArray.findTheTargetUsingLinearSearchAndReturnTheArrayList(arr, 4,0, new ArrayList<>()));
//        System.out.println(RecursionInArray.findTheTargetUsingLinearSearchAndReturnTheArrayListWithoutPassingTheArguments(arr,4,0));
//        System.out.println(RecursionInArray.rotatedBinarySearch(arr,33,0,arr.length-1));
//       PatternUsingRecursion.pattern2(5,0);
//        PatternUsingRecursion.selectionSort(arr,0,arr.length ,0);
//        System.out.println(Arrays.toString(arr));

//      MergeSort.mergeSortInPlace(arr,0,arr.length);
//        System.out.println(Arrays.toString(arr));
//        QuickSort.quickSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(StringUsingRecursion.skipA("bccaabcda"));
//        StringUsingRecursion.SkipAInPlace("","baacdaahad");
//        System.out.println(StringUsingRecursion.skipAppNotApple("thisappleapp"));
//        StringUsingRecursion.subSequence("","abc");
//        System.out.println(StringUsingRecursion.subSequenceInArrayList("","abc"));
//        Dice.makeDice("", 4);
//        int arr[][] = {
//                {1,2,3},
//                {1,2},
//                {5,6,7},
//                {4,6},
//                {4,5,6}
//        };
//        for(int[] a : arr){
//            System.out.print((a[1]));
//            for(int c : a){
////                System.out.print(c);
//            }
//            System.out.println();
//        }


    }
}
