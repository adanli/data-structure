package demo.structure.graph.adjacency_table;

import lombok.Data;

/**
 * 邻接表
 */
@Data
public class AdjacencyTableGraph<T> {
    private int vertexSize;
    private int edgeSize;

    private Vertex<T>[] vertices;

    public AdjacencyTableGraph(int vertexSize, int edgeSize) {
        this.vertexSize = vertexSize;
        this.edgeSize = edgeSize;
        this.vertices = new Vertex[vertexSize];
    }

}
