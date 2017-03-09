package com.alfer.algorithms;

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
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] < a[j]) {
                    int tmp = a[i];
                    for (int k = i; k > j; k--) {
                        a[k] = a[k - 1];
                    }
                    a[j] = tmp;
                    break;
                }
            }
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


    public static void main(String[] args) {
        int[] a = {5, 10, 4, 6, 9, 3, 2, 7, 10, 11};
//        insertSort(a);
        quickSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + ",");
        }
    }
}
