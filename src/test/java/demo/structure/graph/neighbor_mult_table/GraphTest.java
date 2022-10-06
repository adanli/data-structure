package demo.structure.graph.neighbor_mult_table;

import demo.structure.graph.neighbor_multi_table.EdgeNode;
import demo.structure.graph.neighbor_multi_table.NeighborMultiTableGraph;
import demo.structure.graph.neighbor_multi_table.Vertex;
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
        InputEdge e01 = new InputEdge("v0", "v1");
        InputEdge e02 = new InputEdge("v0", "v2");
        InputEdge e03 = new InputEdge("v0", "v3");
        InputEdge e12 = new InputEdge("v1", "v2");
        InputEdge e23 = new InputEdge("v2", "v3");

        edges[0] = e01;
        edges[1] = e02;
        edges[2] = e03;
        edges[3] = e12;
        edges[4] = e23;
    }

    @Test
    public void createNeighborMultiTableGraph() {
        NeighborMultiTableGraph<String> graph = new NeighborMultiTableGraph<>(points.length, edges.length);
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<points.length; i++)  {
            graph.getVertices()[i] = new Vertex<>(points[i]);
            map.put(points[i], i);
        }

        for(int i=0; i<edges.length; i++) {
            graph.getEdges()[i] = new EdgeNode(map.get(edges[i].getFrom()), map.get(edges[i].getTo()));
        }

        graph.connect();

        System.out.println(graph);

    }

}
