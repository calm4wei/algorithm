package com.alfer.algorithms;

import java.util.BitSet;

/**
 * Created on 2016/11/16
 *
 * @author feng.wei
 */
public class StringTopic {

    /**
     * 找出字符串中最长的数字串
     * 例如： 输入字符串为abcd12345ed125ss123456789， 则其中最长的数字串为123456789， 长度为9
     *
     * @param inputStr
     */
    public static void continumax(String inputStr) {
        char[] inputs = inputStr.toCharArray();
        int maxLen = 0;
        int tmp = 0;
        String maxDigtDtr = "";
        String tmpStr = "";
        for (char input : inputs) {
            if (input >= 48 && input <= 57) {
                tmp++;
                tmpStr += input;
                if (maxLen < tmp) {
                    maxLen = tmp;
                    maxDigtDtr = tmpStr;
                }
            } else {
                tmp = 0;
                tmpStr = "";
            }

        }

        System.out.printf("%d, %s", maxLen, maxDigtDtr);

    }

    /**
     * 字符串旋转
     * 例如： 如把字符串abcdef左旋转2位得到字符串cdefab
     *
     * @param inputStr
     * @param n
     */
    static void spinStr(String inputStr, int n) {
        int len = inputStr.length();

        if (len < n) {
            n = n % len;
        }
        String subStr = inputStr.substring(0, n);
        String spinStr = inputStr.substring(n);
        spinStr += subStr;
        System.out.printf(spinStr);
    }

    /**
     * 33.
     * 实现一个挺高级的字符匹配算法：
     * 给一串很长字符串，要求找到符合要求的字符串，例如目的串：123
     * 1******3***2 ,12*****3这些都要找出来
     * 其实就是类似一些和谐系统
     * <p>
     * 此处借助了位图BitSet工具
     *
     * @param s1
     * @param s2
     */
    static void search(String s1, String s2) {
        // TODO Auto-generated method stub
        char[] goal = s2.toCharArray();
        String s3[] = s1.split(",");
        for (int count = 0; count < s3.length; count++) {
            char[] s = s3[count].toCharArray();
            boolean flag = true;
            BitSet bitSet = new BitSet(256);// 用ascii码
            for (int i = 0; i < s.length; i++) {
                bitSet.set(s[i] - ' ', true);
            }
            for (int j = 0; j < goal.length; j++) {
                if (!bitSet.get(goal[j] - ' ')) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("match:    " + s3[count]);
            } else {
                System.out.println("dismatch: " + s3[count]);
            }
        }

    }

    public static void main(String[] args) {
        String inputStr = "abc42";
//        continumax(inputStr);

//        spinStr(inputStr, 7);

        String s1 = "afc32b,hafb32fcadr,thdf";
        String goal = "a23bc";
        search(s1, goal);
    }

}
