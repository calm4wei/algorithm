package com.alfer.algorithms;

import com.alfer.util.NumberUtils;

/**
 * Created on 2016/9/30
 * 排序算法
 *
 * @author feng.wei
 */
public class VariousSort {

    /**
     * 插入排序
     * 升序
     *
     * @param a
     * @return
     */
    public static int[] insertSort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            int i = j - 1;
            while (i >= 0 && a[i] > key) {
                a[i + 1] = a[i];
                i = i - 1;
            }
            a[i + 1] = key;
        }
        return a;
    }

    /**
     * 快速排序
     * 快速排序是C.R.A.Hoare于1962年提出的一种划分交换排序。它采用了一种分治的策略，通常称其为分治法(Divide-and-ConquerMethod)
     * 此处采用三数中值分割法
     *
     * @param a
     * @return
     */
    public static void quickSort(int[] a, int start, int end) {

        if (end <= start) {
            return;
        }

        int center = (start + end) / 2;
        int i = start;
        int j = end;
        while (i < j) {
            int tmp;
            if (a[i] > a[j]) {
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }

            if (a[i] > a[center]) {
                tmp = a[i];
                a[i] = a[center];
                a[center] = tmp;
            }
            i++;

            if (a[j] < a[center]) {
                tmp = a[j];
                a[j] = a[center];
                a[center] = tmp;
            }
            j--;

        }

        if (end - start == 1) {
            return;

        }
        quickSort(a, start, center);
        quickSort(a, center, end);
    }


    /**
     * 算法导论 7.1 第95页
     *
     * @param a
     * @param p
     * @param r
     * @return
     */
    public static int partition(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (a[j] <= x) {
                i++;
                NumberUtils.swap(a, i, j);
            }
        }
        NumberUtils.swap(a, i + 1, r);
        return i + 1;
    }

    public static void quickSort_intro(int[] a, int p, int r) {
        if (r < p)
            return;

        int q = partition(a, p, r);
        quickSort(a, p, q - 1);
        quickSort(a, q + 1, r);

    }

    public static void main(String[] args) {
        int[] a = {1, 10, 4, 6, 9, 3, 2, 7, 10, 11};
//        insertSort(a);
//        for (int i : a) {
//            System.out.print(i + ",");
//        }
        System.out.println("==========");
//        quickSort(a, 0, a.length - 1);
        quickSort_intro(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + ",");
        }
    }
}
