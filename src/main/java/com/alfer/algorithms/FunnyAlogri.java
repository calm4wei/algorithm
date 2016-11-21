package com.alfer.algorithms;

/**
 * Created on 2016/11/16
 *
 * @author feng.wei
 */
public class FunnyAlogri {

    /**
     * 一个台阶总共有n级，如果一次可以跳1级，也可以跳2级。
     * 求总共有多少总跳法，并分析算法的时间复杂度。
     *
     * @param step
     */
    static void drivingTower(int step) {
        // 全走单步
        int sum = 1;

        // 单步为0 全走双步
        if ((sum % 2) == 0) {
            sum += 1;
        }

        // 单步从1到n，双步为(step - i)
        for (int i = 1; i < step; i++) {

            if ((step - i) % 2 != 0) {
                continue;
            } else {
                sum += i * (step - i);
            }

        }

        System.out.printf("sum=%d", sum);
    }

    /**
     * 求一个整数的二进制中1的个数：
     * 输入一个整数，求该整数的二进制表达中有多少个1。例如输入10，由于其二进制表示为1010，有两个1，因此输出2。
     * 解法一：整数依次右移一位，和 1 进行与运算
     * 局限：只适合非负数
     *
     * @param n
     */
    static void numberOf1InBinaryBitOpera(int n) {
        int count = 0;
        while (n != 0) {
            if ((1 & n) == 1) {
                count++;
            }
            n = n >> 1;
        }
        System.out.printf("Bit  count=%d", count);

    }

    /**
     * 问题同上
     * 解法二： 将整数减一(取反)，然后和 1 进行与运算
     *
     * @param n
     */
    static void numberOf1InBinarySub1(int n) {
        System.out.println(Integer.toBinaryString(n));
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        System.out.println("Sub1 count=" + count);

    }

    /**
     * 32.
     * 有两个序列a,b，大小都为n,序列元素的值任意整数，无序；
     * 要求：通过交换a,b中的元素，使[序列a元素的和]与[序列b元素的和]之间的差最小。
     * 例如:
     * var a=[100,99,98,1,2, 3];
     * var b=[1, 2, 3, 4,5,40];
     *
     * @param a
     * @param b
     */
    static void minDifferenceValue(int a[], int b[]) {

        if (a.length != b.length) {
            return;
        }

        System.out.println(sum(a) - sum(b));
        boolean cycle = true;
        while (cycle) {

            cycle = false;
            for (int i = 0; i < a.length; i++) {

                for (int j = 0; j < b.length; j++) {

                    int A = sum(a) - sum(b);

                    // 如果数组a的和大于数组b的和，则交换将数组交换
//                    int[] c;
//                    if (A < 0) {
//                        c = a;
//                        a = b;
//                        b = c;
//                        A = Math.abs(A);
//                    }

                    int x = a[i] - b[j];

                    // 不交换数组，直接用绝对值判断数组差值
                    if (Math.abs(A - 2 * x) < Math.abs(A)) {
                        cycle = true;
                        int tmp;
                        tmp = a[i];
                        a[i] = b[j];
                        b[j] = tmp;
                        System.out.println(sum(a) - sum(b));
                        System.out.printf("  ");
                        for (int k = 0; k < a.length; k++) {
                            System.out.printf(" %d", a[k]);
                        }
                        System.out.println();
                        System.out.printf("  ");
                        for (int k = 0; k < b.length; k++) {
                            System.out.printf(" %d", b[k]);
                        }
                        System.out.println();
                    }

                }

            }

            System.out.println("========================");
        }


    }

    static int sum(int as[]) {
        int s = 0;
        for (int a : as) {
            s += a;
        }
        return s;
    }

    public static void main(String[] args) {
        int n = 7;
        int a[] = {1, 2, 33, 8, 2, 100, 98, 36};
        int b[] = {2, 16, 5, 10, 1, 23, 78, 44};
//        drivingTower(4);
//        countOne(10);
//        numberOf1InBinarySub1(7);
//        numberOf1InBinaryBitOpera(7);
        minDifferenceValue(a, b);
    }
}
