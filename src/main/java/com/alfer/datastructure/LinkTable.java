package com.alfer.datastructure;

import java.util.NoSuchElementException;

/**
 * 双向链表
 * Created on 2017/3/10
 *
 * @author feng.wei
 */
public class LinkTable<E> {

    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;


    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    public E removeFirst() {
        Node<E> f = first;
        if (null == first)
            throw new NoSuchElementException();
        return unlinkFirst(f);

    }

    private E unlinkFirst(Node<E> f) {
        E e = f.item;
        Node<E> next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        if (null == next) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        return e;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index <= size;
    }

    Node<E> node(int index) {
        Node<E> e;
        if (index < (size >> 1)) {
            e = first;
            for (int i = 0; i < index; i++) {
                e = e.next;
            }
        } else {
            e = last;
            for (int i = size - 1; i > index; i--) {
                e = e.prev;
            }
        }
        return e;
    }

    void linkLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<E>(l, e, null);
        last = newNode;
        if (null == l) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

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
        linkTable.add(1);
        linkTable.add(2);
        System.out.println(linkTable.get(2));

        linkTable.removeFirst();
        linkTable.removeFirst();
        System.out.println(linkTable.size);

    }


}

