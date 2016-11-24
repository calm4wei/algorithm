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
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> tmpList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                if (tmpList.size() > 0) {
                    if (tmpList.get(tmpList.size() - 1) > arr[j]) {
                        tmpList.add(arr[j]);
                    }
                } else {
                    tmpList.add(arr[j]);
                }
            }

        }

//        if (list.size() < tmpList.size()) {
//            list = new ArrayList<Integer>();
        for (Integer l : tmpList) {
            System.out.print(l + ", ");
            list.add(l);
        }
//        }
        System.out.println();
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
        subMaxSeq(arr);

    }
}
