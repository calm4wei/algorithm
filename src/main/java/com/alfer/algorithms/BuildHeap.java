package com.alfer.algorithms;

/**
 * 构建大根堆
 * Java实现堆排序（大根堆）：http://www.cnblogs.com/CherishFX/p/4643940.html
 * Created on 2017/3/9
 *
 * @author feng.wei
 */
public class BuildHeap {

    /**
     * 返回左子节点
     *
     * @param i
     * @return
     */
    public static int left(int i) {
        return i * 2 + 1;
    }

    /**
     * 返回右子节点
     *
     * @param i
     * @return
     */
    public static int right(int i) {
        return i * 2 + 2;

    }

    /**
     * @param a
     * @param k
     */
    public static void max_heapify_bak(int[] a, int k) {
        int tmp = a[k];
        int lenght = a.length;
        for (int i = 2 * k + 1; i < a.length; i = i * 2 + 1) { // i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
            if (i < lenght && a[i] < a[i + 1]) { // 取节点较大的子节点的下标
                i++; // 如果节点的右孩子>左孩子，则取右孩子节点的下标
            }
            if (tmp > a[i]) {// 根节点 >=左右子女中关键字较大者，调整结束
                break;
            } else { // 根节点 <左右子女中关键字较大者
                a[k] = a[i]; // 将左右子结点中较大值array[i]调整到双亲节点上
                k = i; //【关键】修改k值，以便继续向下调整
            }
        }
        a[k] = tmp;
    }

    /**
     * 标准 MAX-HEAPIFY 执行过程
     *
     * @param a
     * @param k
     */
    public static void max_heapify(int[] a, int k) {
        int left = left(k);
        int right = right(k);
        int largest;
        int heapSize = a.length;
        if (left < heapSize && a[left] > a[k]) {
            largest = left;

        } else {
            largest = k;
        }

        if (right < heapSize && a[right] > a[largest]) {
            largest = right;
        }

        if (largest != k) {
            swap(a, k, largest);
            max_heapify(a, largest);
        }
    }

    public static void build_max_heap(int[] a) {
        for (int i = (a.length) / 2; i >= 0; i--) { // 从i=a.length/2开始调用Max_heapify()函数，因为 i>a.length/2的节点没有子节点
//            max_heapify(a, i);
            max_heapify(a, i);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public static void main(String[] args) {
        // {87, 45, 78, 32, 17, 65, 53, 9, 122}
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        build_max_heap(a);
        for (int i : a) {
            System.out.print(i);

        }
    }

}
