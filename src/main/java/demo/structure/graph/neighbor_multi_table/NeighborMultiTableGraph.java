package demo.structure.graph.neighbor_multi_table;

import lombok.Data;

/**
 * 邻边多重表
 */
@Data
public class NeighborMultiTableGraph<T> {
    private int pointSize;
    private int edgeSize;
    private Vertex<T>[] vertices;

    public NeighborMultiTableGraph(int pointSize, int edgeSize) {
        this.pointSize = pointSize;
        this.edgeSize = edgeSize;
        this.vertices = new Vertex[pointSize];
    }

}
