package demo.structure.graph.cross_link_table;

import lombok.Data;

/**
 * 十字链表
 */
@Data
public class CrossLinkTableGraph {
    private int vertexSize;
    private int edgeSize;
    private Vertex[] vertices;

    public CrossLinkTableGraph(int vertexSize, int edgeSize) {
        this.vertexSize = vertexSize;
        this.edgeSize = edgeSize;
        this.vertices = new Vertex[vertexSize];
    }

}
