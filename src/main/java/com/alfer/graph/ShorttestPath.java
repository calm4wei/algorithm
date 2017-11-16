package com.alfer.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author alfer
 * @date 11/15/17
 */
public class ShorttestPath {

    public static final int INFINITY = Integer.MAX_VALUE;

    /**
     * 无权最短路径算法
     *
     * @param s
     */
    public static void unweighted(Vertex s) {
        Queue<Vertex> q = new LinkedList<Vertex>();

        s.dist = 0;
        q.add(s);

        while (!q.isEmpty()) {
            Vertex v = q.poll();
            for (Vertex w : v.adjacent) {
                if (w.dist == INFINITY) {
                    w.dist = v.dist + 1;
                    w.path = v;
                    q.add(w);
                }

            }
        }
    }

    public static Vertex find(String name, List<Vertex> graphmap) {
        for (Vertex graph : graphmap) {
            if (graph.name.equals(name)) {
                return graph;
            }
        }
        return null;
    }

    public static void printPath(String graphname, List<Vertex> graphmap) {
        Vertex vertex = find(graphname, graphmap);
        if (vertex.path != null) {
            printPath(vertex.path.name, graphmap);
            System.out.print(" to ");
        }
        System.out.print(vertex.name);
        System.out.println();
    }

    /**
     * 解决单源最短路径问题的一般方法：Dijkstra算法
     */
    public static void dijkstra(Vertex s) {
        s.dist = 0;
        while () {

        }
    }

}
