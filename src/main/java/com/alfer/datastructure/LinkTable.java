package com.alfer.datastructure;

/**
 * Created on 2017/3/10
 *
 * @author feng.wei
 */
public class LinkTable {

    transient int size = 0;

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E elemeent, Node<E> next) {
            this.item = elemeent;
            this.next = next;
            this.prev = prev;
        }

    }

    public static void main(String[] args) {
        LinkTable linkTable = new LinkTable();
        Node node = new Node<Integer>(null, 2, null);
    }


}

