package com.alfer.algorithms;

/**
 * Created on 2016/9/29
 * <p>
 * 计算数组的中子序列的最大和，数组中可以包含负数和零
 * </p>
 *
 * @author feng.wei
 */
public class MaxSubSequence {

    public static void main(String[] args) {
        sumn(1000000, 3);
    }

    public static void sumn(int n, int model) {
        long sum = 0;
        long t1 = System.currentTimeMillis();
        long t2 = 0;
        if (2 == model) {
            for (int i = 0; i < n; i++) {
                sum++;
            }
            t2 = System.currentTimeMillis();

        } else if (3 == model) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sum++;
                }
            }
            t2 = System.currentTimeMillis();
        }
        System.out.println("model" + model + "=" + (t2 - t1) + " , sum=" + sum);

    }


    public static int maxSumRec2(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            int tmpSum = 0;
            for (int j = i; j < a.length; j++) {
                tmpSum += a[j];
                if (tmpSum > maxSum) {
                    maxSum = tmpSum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSumRec3(int[] a, int left, int right) {
        if (left == right) {
            return left;
        }

        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec3(a, left, center);
        int maxRightSum = maxSumRec3(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i++) {
            leftBorderSum += a[i];
            if (maxLeftBorderSum < leftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i < right; i++) {
            rightBorderSum += a[i];
            if (maxRightBorderSum < rightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);

    }

    public static int max3(int a, int b, int c) {
        int max;
        if (a > b) {
            max = a;
        } else {
            max = b;
        }

        if (max < c) {
            max = c;
        }

        return max;
    }
}
