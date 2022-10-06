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
    private EdgeNode[] edges;

    public NeighborMultiTableGraph(int pointSize, int edgeSize) {
        this.pointSize = pointSize;
        this.edgeSize = edgeSize;
        this.vertices = new Vertex<>[pointSize];
        edges = new EdgeNode[edgeSize];
    }

    public void connect() {
        // 1. 建立vertex和edge的关系
        for(EdgeNode node: edges) {
            vertices[node.getIVex()].setFirstEdge(node);
        }

        // 2. 建立edge和edge之间的关系
        for(Vertex vertex: vertices) {// v0, 过滤v0和v1，找到v0和v2、v0和v3
            EdgeNode firstEdge = vertex.getFirstEdge();
            if(firstEdge == null) continue;
            for(EdgeNode edge: edges) {
                if(!vertex.getData().equals(edge.getIVex()) && !vertex.getData().equals(edge.getJVex())) continue;
                if((firstEdge.getIVex()+ firstEdge.getJVex())==(edge.getIVex()+edge.getJVex())
                    && (
                        (firstEdge.getIVex() - firstEdge.getJVex())==(edge.getIVex()-edge.getJVex())
                        || (firstEdge.getIVex() - firstEdge.getJVex())+(edge.getIVex()-edge.getJVex())==0
                        )
                ) continue;

            }
        }

    }

}
