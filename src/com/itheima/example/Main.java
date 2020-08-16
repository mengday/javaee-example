package com.itheima.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

/**
 * summary.
 * <p>
 * detailed description
 *
 * @author Mengday Zhang
 * @version 1.0
 * @since 2020/8/12
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 3, 8, 4, 0, 1, 6, 7};
        quickSort(array);
        quickSort2(array);
        quickSort3(array);
    }

    public static void quickSort(int[] array) {
        int pivot = 0;
        int low = 1;
        int high = array.length - 1;

        // low 从前往后找，找第一个标准值小于low的
        for (int i = low; i < high; i++) {
            if (array[pivot] < array[i]) {
                low = i;
                break;
            }
        }

        // high 从后往前找，找标准值大于high的
        for (int i = high; i >= 0; i--) {
            if (array[pivot] > array[i]) {
                high = i;
                break;
            }
        }

        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;

        System.out.println(array2string(array) + " low=" + low + ", high=" + high);
    }

    public static void quickSort2(int[] array) {
        // 上一次的low和high值
        int pivot = 0;
        int low = 2;
        int high = 7;

        // low 从前往后找，找第一个标准值小于low的
        for (int i = low; i < high; i++) {
            if (array[pivot] < array[i]) {
                low = i;
                break;
            }
        }

        // high 从后往前找，找标准值大于high的
        for (int i = high; i >= low; i--) {
            if (array[pivot] > array[i]) {
                high = i;
                break;
            }
        }

        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;

        System.out.println(array2string(array) + " low=" + low + ", high=" + high);
    }

    public static void quickSort3(int[] array) {
        // 上一次的low和high值
        int pivot = 0;
        int low = 4;
        int high = 6;

        // low 从前往后找，找第一个标准值小于low的
        for (int i = low; i <= high; i++) {
            if (array[pivot] < array[i]) {
                if (low == i) {
                    // array[6] = 0, 无论怎么比较都满足这个条件，跳过上次
                    continue;
                }
                low = i;
                break;
            }
        }

        // high 从后往前找，找标准值大于high的
        for (int i = high; i > 4; i--) {
            if (array[pivot] > array[i]) {
                high = i;
                break;
            }
        }

        System.out.println("low=" + low + ", high=" + high);

        if (low > high) {
            // pivot 和 high 交换
            int temp = array[high];
            if (array[pivot] >= array[high] && array[pivot] <= array[low]) {
                array[high] = array[pivot];
            } else if (array[pivot] <= array[high] && array[pivot] <= array[low]) {
                array[low] = array[pivot];
            }
            array[0] = temp;
        }

        System.out.println(array2string(array));
    }

    public static String array2string(int[] array) {
        StringBuffer sb = new StringBuffer("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
