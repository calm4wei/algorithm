package com.alfer.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2016/11/18
 *
 * @author feng.wei
 */
public class ProducerAndConsumer {

    static List<Integer> quene = new ArrayList<Integer>();

    static class Producer implements Runnable {

        public void run() {
            Integer i = 0;
            while (i < 100) {
                quene.add(i++);
                System.out.println("produce " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        public void run() {
            Integer i = 0;
            while (i < 100) {

                if (quene.size() > 0) {
                    System.out.println("consume " + quene.get(quene.size() - 1));
                    quene.remove(quene.size() - 1);
                } else {
                    try {
                        Thread.sleep(20);
                        if (!(quene.size() > 0)) {
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
