package com.itheima.example;

/**
 * summary.
 * <p>
 * detailed description
 *
 * @author Mengday Zhang
 * @version 1.0
 * @since 2020/8/12
 */
public class ArrayUtils {
    public static String array2String(int[] array) {
        if (array == null) {
            return "";
        }

        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(array2String(a));
    }
}
