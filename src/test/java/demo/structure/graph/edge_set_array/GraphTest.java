package demo.structure.graph.edge_set_array;

import demo.structure.graph.util.InputEdge;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GraphTest {
    private String[] points = new String[]{"v0", "v1", "v2", "v3", "v4"};
    private InputEdge[] edges = new InputEdge[6];

    @Before
    public void init() {
        InputEdge e10 = new InputEdge("v1", "v0", 9);
        InputEdge e12 = new InputEdge("v1", "v2", 3);
        InputEdge e20 = new InputEdge("v2", "v0", 2);
        InputEdge e23 = new InputEdge("v2", "v3", 5);
        InputEdge e34 = new InputEdge("v3", "v4", 1);
        InputEdge e04 = new InputEdge("v0", "v4", 6);

        edges[0] = e10;
        edges[1] = e12;
        edges[2] = e20;
        edges[3] = e23;
        edges[4] = e34;
        edges[5] = e04;
    }

    @Test
    public void createEdgeSetArrayGraph() {
        EdgeSetArrayGraph<String> graph = new EdgeSetArrayGraph<>(points.length, edges.length);
        Map<String, Integer> map = new HashMap<>();
        // 顶点
        for(int i=0; i<points.length; i++) {
            graph.getVertices()[i] = new Vertex<>(points[i]);
            map.put(points[i], i);
        }

        // 边
        for(int i=0; i<edges.length; i++) {
            graph.getEdgeNodes()[i] = new EdgeNode(map.get(edges[i].getFrom()), map.get(edges[i].getTo()), edges[i].getWeight());
        }

        System.out.println(graph);
    }

}
