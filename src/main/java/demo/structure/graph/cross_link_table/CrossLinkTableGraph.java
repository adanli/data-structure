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


    public void attachHeader(Integer from, Integer to) {
        Vertex v = vertices[from];

        Vertex dist = vertices[to];
        EdgeNode n = dist.getFirstOut();
        while (n!=null && (n.getTailVex()!=to || n.getHeadVex()!=from)) {
            n = n.getTailLink();
        }
        v.attachHeader(n);
    }


}
