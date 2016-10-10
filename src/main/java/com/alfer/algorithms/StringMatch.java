package com.alfer.algorithms;

/**
 * Created on 2016/10/10
 * 字符串匹配
 *
 * @author feng.wei
 */
public class StringMatch {

    /**
     * 原始字符串匹配
     *
     * @param target
     * @param pattern
     * @return
     */
    public static int originMatch(String target, String pattern) {
        int flag = -1;
        int tlen = target.length();
        int plen = pattern.length();
        int i = 0, j = 0;

        while ((i + j) < tlen && j < plen) {
            if (target.charAt(i + j) == pattern.charAt(j)) {
                j++;
            } else {
                i++;
                j = 0;
            }
        }

        if (j == plen) {
            flag = i;
        }
        return flag;
    }

    /**
     * 采用KMP算法匹配字符串
     *
     * @param target
     * @param pattern
     * @return
     */
    public static int kmpMatch(String target, String pattern) {
        int flag = -1;
        char[] ps = pattern.toCharArray();
        char[] ts = target.toCharArray();
        int[] next = getNext(ps);
        int i = 0;
        int j = 0;
        while (i < ts.length && j < ps.length) {

            if (j == -1 || ps[j] == ts[i]) {
                i++;
                j++;
            } else {
//                if (next[j] == -1) {
//                    i++;
//                    j = 0;
//                } else if (next[j] == 0) {
//                    j = 0;
//                } else if (next[j] > 0) {
//                    j = next[j];
//                }
                j = next[j];
            }

        }

        if (j == ps.length) {
            flag = i - j;
        }
        return flag;
    }

    /**
     * KMP 取模式值next[n]
     *
     * @param ps
     * @return
     */
    public static int[] getNext(char[] ps) {
        int[] next = new int[ps.length];
        next[0] = -1;
        // 标记字符在字符数组中的位置
        int i = 0;
        // 标记取值模式数组的位置
        int j = -1;
        while (i < ps.length - 1) {
            if (j == -1 || ps[i] == ps[j]) {
                i++;
                j++;
                if (ps[i] != ps[j]) {
                    next[i] = j;
                } else {
                    next[i] = next[j];
                }
            } else {
                j = next[j];
            }
        }
        return next;
    }

    /**
     * 字符串匹配之Sunday算法
     *
     * @return
     */
    public static int sundayMatch(String target, String pattern) {
        int flag = -1;
        int tlen = target.length();
        int plen = pattern.length();
        int i = 0;// 标记目标串的字符的开始位置
        int j = 0;// 标记模式串的字符位置
        int m = 0; //标记目标串匹配模式串的动态位置

        while (i < tlen && j < plen) {
            if (i == 0 && j == 0) {
                if (target.charAt(i) != pattern.charAt(j)) {
                    m = i + plen;
                    for (int k = plen - 1; k >= 0; k--) {
                        if (pattern.charAt(k) == target.charAt(m)) {
                            i = i + (plen - k);
                            break;
                        }
                    }
                }
            }
            if (target.charAt(i) != pattern.charAt(j)) {
                for (int k = (i + plen - j); k < tlen; k++) {
                    if (target.charAt(k) == pattern.charAt(plen - 1)) {
                        m = k;
                        i = m - plen + 1;
                        j = 0;
                        break;

                    }
                }
            } else {
                i++;
                j++;
            }
        }
        if (j == plen) {
            flag = i - plen;
        }
        return flag;
    }

    public static void main(String[] args) {
        String target = "012334567892345";
        String pattern = "2345";
        System.out.println(originMatch(target, pattern));
        System.out.println(kmpMatch(target, pattern));
        System.out.println(sundayMatch(target, pattern));
    }

}
