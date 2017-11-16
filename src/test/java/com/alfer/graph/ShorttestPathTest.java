package com.alfer.graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author alfer
 * @date 11/15/17
 */
public class ShorttestPathTest {

    @Test
    public void testUnweighted() {
        List<Vertex> graphmap = new LinkedList<Vertex>();

        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");

        graphmap.add(v1);
        graphmap.add(v2);
        graphmap.add(v3);
        graphmap.add(v4);
        graphmap.add(v5);
        graphmap.add(v6);
        graphmap.add(v7);

        for (Vertex g : graphmap) {
            g.dist = ShorttestPath.INFINITY;
            g.path = null;
        }

        v1.adjacent.add(v2);
        v1.adjacent.add(v4);

        v2.adjacent.add(v4);
        v2.adjacent.add(v5);

        v3.adjacent.add(v1);
        v3.adjacent.add(v6);

        v4.adjacent.add(v3);
        v4.adjacent.add(v5);
        v4.adjacent.add(v6);
        v4.adjacent.add(v7);

        v5.adjacent.add(v7);

        v7.adjacent.add(v6);

        List<Vertex> vs = new ArrayList<Vertex>();
        vs.add(v1);
        vs.add(v2);
        vs.add(v3);
        vs.add(v4);
        vs.add(v5);
        vs.add(v6);
        vs.add(v7);
        ShorttestPath.unweighted(v3);
        System.out.println("The shortest path from v3:");
        for (int i = 1; i <= 7; i++) {
            ShorttestPath.printPath("v" + i, graphmap);
        }
    }
}
