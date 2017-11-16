package com.alfer.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created on 2016/9/19
 * 二叉树遍历
 *
 * @author feng.wei
 */
public class BinaryTreeNode implements Cloneable {

    Integer value;
    BinaryTreeNode leftNode;
    BinaryTreeNode rightNode;

    public BinaryTreeNode() {

    }

    public BinaryTreeNode(Integer value, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    /**
     * 前序（根）遍历
     * 递归实现
     * current -> left -> right
     *
     * @param btn
     */
    void preOrderTraversal(BinaryTreeNode btn) {
        if (btn != null) {
            System.out.print(btn.value + ", ");
            if (btn.leftNode != null) {
                preOrderTraversal(btn.leftNode);
            }
            if (btn.rightNode != null) {
                preOrderTraversal(btn.rightNode);
            }
        }

    }

    /**
     * 前序（根）遍历
     * 非递归实现：使用栈
     *
     * @param btn
     */
    void preOrderTraversal2(BinaryTreeNode btn) {
        System.out.println();
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(btn);

        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            System.out.print(node.value + ", ");

            if (node.rightNode != null) {
                stack.push(node.rightNode);
            }

            if (node.leftNode != null) {
                stack.push(node.leftNode);
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
//            System.out.print("Left tree traversal is over.");
            System.out.print(btn.value + ", ");
//            System.out.print("Root tree traversal is over.");
            if (btn.rightNode != null) {
                inOrderTraversal(btn.rightNode);
            }
//            System.out.print("Right tree traversal is over.");
        }
    }

    /**
     * 中序遍历的非递归实现：使用栈作为辅助数据结构。
     * left -> current -> right
     *
     * @param btn
     */
    void inOrderTraversal2(BinaryTreeNode btn) {
        System.out.println();
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode node = btn;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {// 压入node.left
                stack.push(node); // 先压入node，后压入node.left
                node = node.leftNode;
            } else {
                node = stack.pop(); // 先弹出，后压入node.right
                System.out.print(node.value + ", ");
                node = node.rightNode;
            }
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
            if (btn.rightNode != null) {
                postOrderTraversal(btn.rightNode);
            }
            System.out.print(btn.value + ", ");
        }
    }

    /**
     * 层序遍历
     *
     * @param btn
     */
    void levelOrderTraversal(List<BinaryTreeNode> btn) {
        List<BinaryTreeNode> newBtn = new ArrayList<BinaryTreeNode>();
        for (BinaryTreeNode b : btn) {
            System.out.print(b.value + ", ");
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

    /**
     * 二叉树镜像
     *
     * @param treeNode
     */
    void mirrorTree(BinaryTreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
//        mirrorTreeNode = new BinaryTreeNode(treeNode.value, treeNode.rightNode, treeNode.leftNode);

        BinaryTreeNode tmp = treeNode.leftNode;
        treeNode.leftNode = treeNode.rightNode;
        treeNode.rightNode = tmp;
        if (treeNode.leftNode != null) {
            mirrorTree(treeNode.leftNode);
        }

        if (treeNode.rightNode != null) {
            mirrorTree(treeNode.rightNode);
        }

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        BinaryTreeNode node = null;
        node = (BinaryTreeNode) super.clone();
        node.leftNode = (BinaryTreeNode) leftNode.clone();
        node.rightNode = (BinaryTreeNode) rightNode.clone();
        return node;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        BinaryTreeNode tree7 = new BinaryTreeNode(50, null, null);
        BinaryTreeNode tree6 = new BinaryTreeNode(40, null, null);
        BinaryTreeNode tree5 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode tree4 = new BinaryTreeNode(3, null, null);
        BinaryTreeNode tree3 = new BinaryTreeNode(30, tree6, tree7);
        BinaryTreeNode tree2 = new BinaryTreeNode(2, tree4, tree5);
        BinaryTreeNode tree1 = new BinaryTreeNode(1, tree2, tree3);

        // 先序遍历
//        tree1.preOrderTraversal(tree1);
//        tree1.preOrderTraversal2(tree1);
        // 中序遍历
        tree1.inOrderTraversal(tree1);
        tree1.inOrderTraversal2(tree1);
        // 后序遍历
//        tree1.postOrderTraversal(tree1);

        // test 层序遍历
//        List<BinaryTreeNode> list = new ArrayList<BinaryTreeNode>();
//        list.add(tree1);
//        tree1.levelOrderTraversal(list);

        // 二叉树镜像
//        tree1.preOrderTraversal(tree1);
//        System.out.println();
//        System.out.println("===================");
//        tree1.mirrorTree(tree1);
//        tree1.preOrderTraversal(tree1);

    }

}
