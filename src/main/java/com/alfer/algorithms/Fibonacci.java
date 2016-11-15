package com.alfer.algorithms;

/**
 * Created on 2016/11/15
 *
 * @author feng.wei
 */
public class Fibonacci {

    /**
     * Fibonacci with recursion
     * O(2^n)
     *
     * @param n
     * @return
     */
    public static int rescureFiab(int n) {

        if (n < 2) {
            return n;
        }
        return rescureFiab(n - 1) + rescureFiab(n - 2);
    }

    /**
     * 暂存法计算Fibonacci数列
     * 复杂度为O(n)
     * 与递归算法的比较：复杂度远远小于递归算法
     *
     * @param n
     * @return
     */
    public static int find(int n) {
        int a = 0;
        int b = 1;
        int c = 0;

        if (n < 2) {
            return n;
        }

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 40;
        long t1 = System.currentTimeMillis();
        int numa = rescureFiab(n);
        long t2 = System.currentTimeMillis();
        System.out.printf("numa=%d; elapse time=%d%n", numa, (t2 - t1));
        long t3 = System.currentTimeMillis();
        int numb = find(n);
        long t4 = System.currentTimeMillis();
        System.out.printf("numb=%d; elapse time=%d", numb, (t4 - t3));

    }
}
