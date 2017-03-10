package com.alfer.util;

/**
 * Created on 2017/3/9
 *
 * @author feng.wei
 */
public class NumberUtils {

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
