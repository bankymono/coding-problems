package recursion.sorting;

import java.util.Arrays;

public class MergeSortV2 {
    public static void main(String[] args) {
        int[] arr= {8,3,4,12,5,6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0,arr.length);
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if(end - start == 1) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);

        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int s, int m, int e) {
        int[] result = new int[e - s];

        int i = s;
        int j = m;
        int k = 0;

        while(i < m && j < e) {
            if(arr[i] < arr[j]) {
                result[k] = arr[i];
                i++;
            } else {
                result[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i < m ){
            result[k] = arr[i];
            i++;
            k++;
        }

        while(j < e){
            result[k] = arr[j];
            j++;
            k++;
        }

        for(int l = 0; l < result.length; l++) {
            arr[s + l] = result[l];
        }
    }

}
