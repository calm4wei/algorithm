package com.alfer.algorithms;

/**
 * 二叉搜索树
 * Created by fengwei on 17/3/17.
 */
public class BinarySearch {

    Integer value;
    BinarySearch leftNode;
    BinarySearch rightNode;

    public BinarySearch() {

    }

    public BinarySearch(Integer value, BinarySearch leftNode, BinarySearch rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    /**
     * 二叉搜索树的插入实现
     *
     * @param root
     * @param z
     */
    void tree_insert(BinarySearch root, BinarySearch z) {
        BinarySearch y = null;
        BinarySearch x = root;
        // 找到插入的位置
        while (x != null) {
            y = x;
            if (z.value < x.value) {
                x = x.leftNode;
            } else {
                x = x.rightNode;
            }
        }

        // 将节点z插入到y的左节点或者右节点
        if (y == null) {
            root = z; // 空树
        } else if (z.value < y.value) {
            y.leftNode = z;
        } else {
            y.rightNode = z;
        }
    }

    /**
     * 二叉搜索树插入的递归实现
     *
     * @param root
     * @param z
     */
    void tree_insert2(BinarySearch root, BinarySearch z) {
        BinarySearch y = null;
        BinarySearch x = root;
        // 找到插入的位置
        y = findNode(z, y, x);

        // 将节点z插入到y的左节点或者右节点
        if (y == null) {
            root = z; // 空树
        } else if (z.value < y.value) {
            y.leftNode = z;
        } else {
            y.rightNode = z;
        }
    }

    BinarySearch findNode(BinarySearch z, BinarySearch y, BinarySearch x) {
        if (x != null) {
            y = x;
            if (z.value < x.value) {
                x = x.leftNode;
            } else {
                x = x.rightNode;
            }
            y = findNode(z, y, x);
        }
        return y;
    }


    /**
     * 迭代实现：
     * 查找二叉搜索树中的最大值
     *
     * @param x
     */
    BinarySearch tree_maximun(BinarySearch x) {
        while (x.rightNode != null) {
            x = x.rightNode;
        }
        return x;
    }

    /**
     * 迭代实现：
     * 查找二叉搜索树中的最小值
     *
     * @param x
     */
    BinarySearch tree_minimun(BinarySearch x) {
        while (x.leftNode != null) {
            x = x.leftNode;
        }
        return x;
    }

    /**
     * 递归实现：
     * 查找二叉搜索树中的最大值
     *
     * @param x
     */
    BinarySearch tree_maximun2(BinarySearch x) {
        if (null == x) {
            return x;
        }
        if (x.rightNode != null) {
            x = x.rightNode;
            x = tree_maximun2(x);
        }
        return x;
    }

    /**
     * 递归实现：
     * 查找二叉搜索树中的最小值
     *
     * @param x
     */
    BinarySearch tree_minimun2(BinarySearch x) {
        if (null == x) {
            return x;
        }
        if (x.leftNode != null) {
            x = x.leftNode;
            x = tree_minimun2(x);
        }

        return x;
    }

    /**
     * 中序（根）遍历
     * left -> current -> right
     *
     * @param btn
     */
    void inOrderTraversal(BinarySearch btn) {

        if (btn != null) {
            if (btn.leftNode != null) {
                inOrderTraversal(btn.leftNode);
            }
            System.out.print(btn.value + ", ");
            if (btn.rightNode != null) {
                inOrderTraversal(btn.rightNode);
            }
        }
    }


    public static void main(String[] args) {
        BinarySearch tree7 = new BinarySearch(13, null, null);
        BinarySearch tree6 = new BinarySearch(11, null, null);
        BinarySearch tree5 = new BinarySearch(12, tree6, tree7);
        BinarySearch tree4 = new BinarySearch(5, null, null);
        BinarySearch tree3 = new BinarySearch(2, null, null);
        BinarySearch tree2 = new BinarySearch(3, tree3, tree4);
        BinarySearch tree = new BinarySearch(10, tree2, tree5);

        System.out.println(tree.tree_maximun2(tree).value);
        System.out.println(tree.tree_maximun(tree).value);
        System.out.println(tree.tree_minimun2(tree).value);
        System.out.println(tree.tree_minimun(tree).value);
        tree.inOrderTraversal(tree);

        BinarySearch z = new BinarySearch(4, null, null);
        tree.tree_insert2(tree, z);
        System.out.println();
        tree.inOrderTraversal(tree);
    }

}
