package com.itheima.example;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 3, 8, 4, 0, 1, 6, 7};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }


    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }


    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // 找出位置
            int index = getIndex(array, low, high);

            // 左分区
            quickSort(array, low, index - 1);
            // 右分区
            quickSort(array, index + 1, high);
        }
    }

    private static int getIndex(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            // 从后往前找，找出第一个比基准值小的
            // 如果后面数组元素大于基准值证明该值不是需要的，继续往前寻找
            // 如果找到一个元素值小于基准值的证明则找到了
            while (array[high] >= pivot && low < high ) {
                high--;
            }

            // 如果从后往前找到了，就把high位置上的值赋值给low位置上的值
            if (low < high) {
                array[low] = array[high];
                low++;
            }

            // 从前往后找，找出第一个比基准值大的
            // 循环条件：如果元素比基准值小不满足条件，继续向前寻找
            while (low < high && array[low] < pivot) {
                low++;
            }
            if (low < high) {
                array[high] = array[low];
                high--;
            }
        }

        array[low] = pivot;

        System.out.println("index=" + low + ", array=" + Arrays.toString(array));
        return low;
    }
}
