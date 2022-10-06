package demo.structure.graph.cross_link_table;

import demo.structure.graph.util.InputEdge;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GraphTest {
    private final String[] points = new String[]{"v0", "v1", "v2", "v3"};
    private final InputEdge[] edges = new InputEdge[5];

    @Before
    public void init() {
        InputEdge e10 = new InputEdge("v1", "v0");
        InputEdge e03 = new InputEdge("v0", "v3");
        InputEdge e20 = new InputEdge("v2", "v0");
        InputEdge e12 = new InputEdge("v1", "v2");
        InputEdge e21 = new InputEdge("v2", "v1");

        edges[0] = e10;
        edges[1] = e03;
        edges[2] = e20;
        edges[3] = e12;
        edges[4] = e21;
    }

    @Test
    public void createCrossLinkTableGraph() {
        CrossLinkTableGraph graph = new CrossLinkTableGraph(points.length, edges.length);
        for(int i=0; i<points.length; i++) {
            Vertex<String> vertex = new Vertex<>(points[i]);
            graph.getVertices()[i] = vertex;
        }

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<points.length; i++) map.put(points[i], i);

        for(InputEdge edge: edges) {
            Integer from = map.get(edge.getFrom());
            Integer to = map.get(edge.getTo());
            // 入度

        }

    }

}
