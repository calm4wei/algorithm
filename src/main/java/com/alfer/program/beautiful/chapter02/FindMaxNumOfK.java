package com.alfer.program.beautiful.chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by fengwei on 17/2/26.
 */
public class FindMaxNumOfK {


    /**
     * 解法二：
     * 利用快速排序方法找出数组中最大的k个数，但只需要进行局部排序分组，步骤如下：
     * 1、判断数组s的长度是否小于k，如果小于等于k则直接输出s，如果不小于k，则进行第二步；
     * 2、从数组s中选取一个随机数交换给s[1]，根据s[1]将数据s分成两组，数组sa中的数都大于s[1]，数组sb中中的数都小于s[1]；
     * 3、将数组sa作为步骤一的输入，sa的长度小于等于k为止。
     *
     * @param s
     * @param k 数组中最大的数的个数
     * @return
     */
    public static List<Integer> kBig(List<Integer> s, Integer k) {
        if (k <= 0) {
            return new ArrayList<Integer>();
        }
        if (s.size() <= k) {
            return s;
        }

        List<Integer> sa = partition(s).get(0);
        List<Integer> sb = partition(s).get(1);

        List<Integer> listk = kBig(sa, k);
        listk.addAll(kBig(sb, k - sa.size()));

        return listk;

    }

    public static List<List<Integer>> partition(List<Integer> s) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> saList = new ArrayList<Integer>();
        List<Integer> sbList = new ArrayList<Integer>();
        Random random = new Random();
        swap(s, 0, random.nextInt(s.size()));
        int p = s.get(0);
        for (int i = 1; i < s.size(); i++) {
            if (s.get(i) > p) {
                saList.add(s.get(i));
            } else {
                sbList.add(s.get(i));
            }
        }

        if (saList.size() < sbList.size()) {
            saList.add(p);
        } else {
            sbList.add(p);
        }
        list.add(saList);
        list.add(sbList);

        return list;
    }

    public static List<Integer> swap(List<Integer> s, int index1, int index2) {
        int tmp = s.get(index1);
        s.set(index1, s.get(index2));
        s.set(index2, tmp);
        return s;
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{10, 2, 4, 20, 5, 7};
        List<Integer> list = kBig(Arrays.asList(arr), 2);
        for (Integer l : list) {
            System.out.println(l);

        }
    }

}
