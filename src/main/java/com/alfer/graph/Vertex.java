package com.alfer.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author alfer
 * @date 11/15/17
 */
public class Vertex {

    String name;
    List<Vertex> adjacent = new LinkedList<Vertex>();
    boolean known;
    int dist;
    Vertex path;

    public Vertex(String name) {
        this.name = name;
    }

    public Vertex find(String name) {
        if (name == this.name) {
            return this;
        }
        for (Vertex graph : adjacent) {
            if (graph.name.equals(name)) {
                return graph;
            }
        }
        return null;
    }

    public void printPath(String graphname) {
        Vertex vertex = find(graphname);
        if (vertex.path != null) {
            printPath(vertex.path.name);
            System.out.print("to");
        }
        System.out.println(vertex.name);
    }
}
