package demo.structure.graph.adjacency_matrix;

import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GraphTest {
    final String[] vertexes = new String[]{"A", "B", "C", "D", "E"};
    final InputEdge[] edges = new InputEdge[6];

    @Before
    public void init() {
        InputEdge e1 = new InputEdge("A", "B");
        InputEdge e2 = new InputEdge("B", "C");
        InputEdge e3 = new InputEdge("C", "D");
        InputEdge e4 = new InputEdge("D", "E");
        InputEdge e5 = new InputEdge("E", "A");
        InputEdge e6 = new InputEdge("B", "E");

        edges[0] = e1;
        edges[1] = e2;
        edges[2] = e3;
        edges[3] = e4;
        edges[4] = e5;
        edges[5] = e6;
    }

    @Test
    public void createAdjacencyMatrix() {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<vertexes.length; i++) {
            map.put(vertexes[i], i);
        }

        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(vertexes.length, edges.length);
        // 构建点
        System.arraycopy(vertexes, 0, graph.getVertexes(), 0, vertexes.length);
        // 构建边
        for(int i=0; i<vertexes.length; i++) {
            for(int j=0; j<vertexes.length; j++) {
                graph.getEdges()[i][j] = 0;
            }
        }
        // 填充边的值
        for (InputEdge edge : edges) {
            String from = edge.from;
            String to = edge.to;
            graph.getEdges()[map.get(from)][map.get(to)] = 1;
            graph.getEdges()[map.get(to)][map.get(from)] = 1;
        }
        System.out.println(graph);
    }

    @Data
    static class InputEdge {
        String from;
        String to;

        public InputEdge(String from, String to) {
            this.from = from;
            this.to = to;
        }
    }

}
