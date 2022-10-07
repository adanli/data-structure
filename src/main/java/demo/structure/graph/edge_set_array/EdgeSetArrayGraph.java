package demo.structure.graph.edge_set_array;

import lombok.Data;

@Data
public class EdgeSetArrayGraph<T> {
    private int vertexSize;
    private int edgeSize;
    private Vertex<T>[] vertices;
    private EdgeNode[] edgeNodes;

    public EdgeSetArrayGraph(int vertexSize, int edgeSize) {
        this.vertexSize = vertexSize;
        this.edgeSize = edgeSize;
        this.vertices = new Vertex[vertexSize];
        this.edgeNodes = new EdgeNode[edgeSize];
    }

}
