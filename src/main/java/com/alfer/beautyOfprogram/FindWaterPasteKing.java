package com.alfer.beautyOfprogram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 编程之美：找出发帖水王
 * Created on 2017/3/8
 *
 * @author feng.wei
 */
public class FindWaterPasteKing {

    public static void main(String[] args) {
        int[] allIds = {65, 96, 65, 54, 65, 79, 65, 8, 65, 5, 65, 21, 65, 43, 65, 90, 65, 83, 65, 39, 65, 48, 65, 76, 65, 79, 65, 57, 65, 65};
        findWaterKing01(allIds);
        findWaterKing02(allIds);
        findWaterKing03(allIds);
        System.out.println(2 ^ 5);// 10 101 => 111
    }

    /**
     * 第一种 : 先遍历一次所有的帖子, 统计出 <发帖人, 发帖次数>, 然后在遍历一次映射, 找出发帖次数超过一半的发帖人 即为所求
     * O(N)
     *
     * @param allIds
     */
    public static void findWaterKing01(int[] allIds) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int id : allIds) {
            if (map.containsKey(id)) {
                map.put(id, map.get(id) + 1);
            } else {
                map.put(id, 1);
            }
        }

        int half = allIds.length / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > half) {
                System.out.println("Waster Paster King' Id is: " + entry.getKey());
                break;
            }
        }
    }

    /**
     * 将所有的id[包括重复]进行排序, 然后最中间的id即为所求
     *
     * @param allIds
     */
    public static void findWaterKing02(int[] allIds) {
        Arrays.sort(allIds);
        System.out.println("Waster Paster King' Id is: " + allIds[allIds.length / 2]);
    }

    /**
     * 逐渐减小问题的规模的算法, 每一次删除两个不同的id, 那么剩下的id列表中, 水贴王的出现次数必然也满足超过一半[因为, 如果删除的两个id中没有水贴王id,
     * 水贴王id出现的次数必然超过一半 [x/ sum => x/ sum-2], 如果删除的两个id中有一个为水贴王id, 则水贴王id出现的次数仍然会超过一半[x/ sum => x - 1/ sum - 2] ]
     *
     * @param allIds
     */
    public static void findWaterKing03(int[] allIds) {

        // 水王候选人
        int candidate = -1;
        int cnt = 0;
        for (int i = 0; i < allIds.length; i++) {
            if (cnt == 0) {
                candidate = allIds[i];
                cnt++;
            } else {
                if (candidate == allIds[i]) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }
        System.out.println("Waster Paster King' Id is: " + candidate);
    }
}
