package com.alfer.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengwei on 16/11/19.
 */
public class Topic {


    /**
     * 谷歌笔试：
     * n支队伍比赛，分别编号为0，1，2。。。。n-1，已知它们之间的实力对比关系，
     * 存储在一个二维数组w[n][n]中，w[i][j] 的值代表编号为i，j的队伍中更强的一支。
     * <p>
     * 所以w[i][j]=i 或者j，现在给出它们的出场顺序，并存储在数组order[n]中，
     * 比如order[n] = {4,3,5,8,1......}，那么第一轮比赛就是 4对3， 5对8。.......
     * 胜者晋级，败者淘汰，同一轮淘汰的所有队伍排名不再细分，即可以随便排，
     * 下一轮由上一轮的胜者按照顺序，再依次两两比，比如可能是4对5,直至出现第一名
     * <p>
     * 编程实现，给出二维数组w，一维数组order 和 用于输出比赛名次的数组result[n]，
     * 求出result。
     *
     * @param w
     * @param order
     * @param result
     */
    static void google36(int[][] w, int[] order, int[] result) {

        int out = 0;
        List<Integer> nextOrder = new ArrayList<Integer>();
        for (Integer o : order) {
            nextOrder.add(o);
        }

        while (nextOrder.size() > 1) {

//            int playNumber;
//            if ((nextOrder.size() % 2) != 0){
//            }

            int k = 0;
            List<Integer> currentOrder = new ArrayList<Integer>();
            for (Integer n : nextOrder) {
                currentOrder.add(n);
            }
            for (int i = 0; i < (currentOrder.size()); i = i + 2) {

                if (w[currentOrder.get(i)][currentOrder.get(i + 1)] != currentOrder.get(i)) {
                    result[out] = currentOrder.get(i);
                    nextOrder.remove(i - k);
                } else {
                    result[out] = currentOrder.get(i + 1);
                    nextOrder.remove(i + 1 - k);
                }
                k++;
                out++;

            }

        }

        for (Integer r : result) {
            System.out.printf("%d, ", r);
        }
    }

    /**
     * 47.创新工场：
     * 求一个数组的最长递减子序列 比如{9，4，3，2，5，4，3，2}的最长递减子序列为{9，5，4，3，2}
     *
     * @param arr
     */
    static void subMaxSeq(int[] arr) {
    }


    /**
     * 遍历最长递减子序列，递归法 A - 源序列数组
     * B - 通过DP求出的辅助数组
     * k - 使得B[i]最大的i值
     */
    static void max_dec_subseq_traverse(int[] A, int[] B, int k) {
        int i;
        for (i = k; i >= 0; i--) {
            if (A[i] > A[k] && B[k] == B[i] + 1) {
                max_dec_subseq_traverse(A, B, i);
                break;
            }
        }
        System.out.println("A[" + k + "]=" + A[k]);
    }

    /**
     * 47.创新工场：
     * 求一个数组的最长递减子序列 比如{9，4，3，2，5，4，3，2}的最长递减子序列为{9，5，4，3，2}
     * <p>
     * <p>
     * 参考：http://blog.csdn.net/army_war/article/details/38236085
     * <p>
     * DP(动态规划)法求解最长递减子序列
     * A - 源序列数组
     * len - 数组大小
     */
    static void max_dec_subseq(int[] A, int len) {
        int i, j, max_i = 0;
        int[] B = new int[len];
        for (i = 0; i < len; i++) {
            B[i] = 1;
            for (j = 0; j < i; j++) {
                if (A[j] > A[i] && (B[j] + 1) > B[i]) {
                    B[i] = B[j] + 1;
                    if (B[i] > B[max_i])
                        max_i = i;
                }
            }
        }
        max_dec_subseq_traverse(A, B, max_i);
    }

    public static void main(String[] args) {
        // google36
//        int[][] w = {
//                {0, 0, 2, 0},
//                {0, 1, 1, 3},
//                {2, 1, 2, 3},
//                {0, 3, 3, 3}
//        };
//
//        int[] order = {0, 3, 2, 1};
//        int[] result = new int[order.length];
//        google36(w, order, result);

        // subMaxSeq
        int[] arr = {6, 9, 4, 3, 2, 5, 4, 3, 2};
        max_dec_subseq(arr, arr.length);

    }
}
