package com.alfer.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2016/9/19
 * 二叉树遍历
 *
 * @author feng.wei
 */
public class BinaryTreeNode {

    Integer value;
    BinaryTreeNode leftNode;
    BinaryTreeNode rightNode;

    public BinaryTreeNode(Integer value, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    /**
     * 前序（根）遍历
     * current -> left -> right
     *
     * @param btn
     */
    void preOrderTraversal(BinaryTreeNode btn) {
        if (btn != null) {
            System.out.println(btn.value);
            if (btn.leftNode != null) {
                preOrderTraversal(btn.leftNode);
            }
            if (btn.rightNode != null) {
                preOrderTraversal(btn.rightNode);
            }
        }
    }

    /**
     * 中序（根）遍历
     * left -> current -> right
     *
     * @param btn
     */
    void inOrderTraversal(BinaryTreeNode btn) {

        if (btn != null) {
            if (btn.leftNode != null) {
                inOrderTraversal(btn.leftNode);
            }
//            System.out.println("Left tree traversal is over.");
            System.out.println(btn.value);
//            System.out.println("Root tree traversal is over.");
            if (btn.rightNode != null) {
                inOrderTraversal(btn.rightNode);
            }
//            System.out.println("Right tree traversal is over.");
        }
    }

    /**
     * 后序（根 ）遍历
     * left -> right -> current
     *
     * @param btn
     */
    void postOrderTraversal(BinaryTreeNode btn) {
        if (btn != null) {
            if (btn.leftNode != null) {
                postOrderTraversal(btn.leftNode);
            }
//            System.out.println("Left tree traversal is over.");
            if (btn.rightNode != null) {
                postOrderTraversal(btn.rightNode);
            }
//            System.out.println("Right tree traversal is over.");
            System.out.println(btn.value);
//            System.out.println("Root tree traversal is over.");
        }
    }

    /**
     * 层序遍历
     *
     * @param btn
     */
    void levelOrderTraversal(List<BinaryTreeNode> btn) {
        List<BinaryTreeNode> newBtn = new ArrayList<>();
        for (BinaryTreeNode b : btn) {
            System.out.println(b.value);
            if (b.leftNode != null) {
                newBtn.add(b.leftNode);
            }
            if (b.rightNode != null) {
                newBtn.add(b.rightNode);
            }
        }

        if (newBtn.size() > 0) {
            levelOrderTraversal(newBtn);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode tree7 = new BinaryTreeNode(50, null, null);
        BinaryTreeNode tree6 = new BinaryTreeNode(40, null, null);
        BinaryTreeNode tree5 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode tree4 = new BinaryTreeNode(3, null, null);
        BinaryTreeNode tree3 = new BinaryTreeNode(30, tree6, tree7);
        BinaryTreeNode tree2 = new BinaryTreeNode(2, tree4, tree5);
        BinaryTreeNode tree1 = new BinaryTreeNode(1, tree2, tree3);

//        tree1.preOrderTraversal(tree1);
//        tree1.inOrderTraversal(tree1);
//        tree1.postOrderTraversal(tree1);
        List<BinaryTreeNode> list = new ArrayList<BinaryTreeNode>();
        list.add(tree1);
        tree1.levelOrderTraversal(list);
    }

}
