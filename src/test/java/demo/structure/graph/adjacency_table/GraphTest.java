package demo.structure.graph.adjacency_table;

import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GraphTest {
    private final String[] points = new String[]{"v0", "v1", "v2", "v3"};
    InputEdge[] edges = new InputEdge[10];
    AdjacencyTableGraph<String> graph = new AdjacencyTableGraph<>(points.length, edges.length);

    @Before
    public void init() {
        InputEdge e01 = new InputEdge("v0", "v1");
        InputEdge e02 = new InputEdge("v0", "v2");
        InputEdge e03 = new InputEdge("v0", "v3");
        InputEdge e10 = new InputEdge("v1", "v0");
        InputEdge e12 = new InputEdge("v1", "v2");
        InputEdge e20 = new InputEdge("v2", "v0");
        InputEdge e21 = new InputEdge("v2", "v1");
        InputEdge e23 = new InputEdge("v2", "v3");
        InputEdge e30 = new InputEdge("v3", "v0");
        InputEdge e32 = new InputEdge("v3", "v2");

        edges[0] = e01;
        edges[1] = e02;
        edges[2] = e03;
        edges[3] = e10;
        edges[4] = e12;
        edges[5] = e20;
        edges[6] = e21;
        edges[7] = e23;
        edges[8] = e30;
        edges[9] = e32;
    }

    /**
     * 无向图
     * 1. 构建点
     * 2. 构建边
     */
    @Test
    public void createAdjacencyTableGraph() {
        for(int i=0; i<points.length; i++) {
            Vertex<String> vertex = new Vertex<>(points[i]);
            graph.getVertices()[i] = vertex;
        }

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<points.length; i++) {
            map.put(points[i], i);
        }

        for (InputEdge edge : edges) {
            Integer from = map.get(edge.from);
            Integer to = map.get(edge.to);
            graph.getVertices()[from].attachNode(to);
        }

        for (int i = 0; i < graph.getVertices().length; i++) {
            System.out.println(graph.getVertices()[i]);
        }

    }

    private final String[] points2 = new String[]{"v0", "v1", "v2", "v3", "v4"};
    InputEdge[] edges2 = new InputEdge[6];

    @Before
    public void init2() {
        InputEdge e10 = new InputEdge("v1", "v0", 9);
        InputEdge e12 = new InputEdge("v1", "v2", 3);
        InputEdge e20 = new InputEdge("v2", "v0", 2);
        InputEdge e04 = new InputEdge("v0", "v4", 6);
        InputEdge e23 = new InputEdge("v2", "v3", 5);
        InputEdge e34 = new InputEdge("v3", "v4", 1);

        edges2[0] = e10;
        edges2[1] = e12;
        edges2[2] = e20;
        edges2[3] = e04;
        edges2[4] = e23;
        edges2[5] = e34;
    }

    /**
     * 构建有向图
     */
    @Test
    public void createAdjacencyTableWithDirection() {
        AdjacencyTableGraph<String> graph = new AdjacencyTableGraph<>(points2.length, edges2.length);
        for(int i=0; i<points2.length; i++) {
            Vertex<String> v = new Vertex<>(points2[i]);
            graph.getVertices()[i] = v;
        }

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<points2.length; i++) map.put(points2[i], i);

        for(InputEdge edge: edges2) {
            Integer from = map.get(edge.from);
            Integer to = map.get(edge.to);
            EdgeNode n = new EdgeNode(to);
            n.setWeight(edge.weight);
//            graph.getVertices()[from].attachNode(to);
            graph.getVertices()[from].attachNode(n);
        }

        for (int i = 0; i < graph.getVertices().length; i++) {
            System.out.println(graph.getVertices()[i]);
        }

    }

    @Data
    static class InputEdge {
        String from;
        String to;
        Integer weight;

        public InputEdge(String from, String to) {
            this.from = from;
            this.to = to;
        }

        public InputEdge(String from, String to, Integer weight) {
            this(from, to);
            this.weight = weight;
        }
    }

    @Test
    public void deepTraversal() {
        createAdjacencyTableGraph();
        graph.deepTraversal();
    }

    @Test
    public void breadthTraversal() {
        createAdjacencyTableGraph();
        graph.breadthTraversal();
    }

}
