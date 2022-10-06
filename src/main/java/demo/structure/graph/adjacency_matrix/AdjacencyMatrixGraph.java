package demo.structure.graph.adjacency_matrix;

import lombok.Data;

/**
 * 图 - 邻接矩阵 - 无向图
 */
@Data
public class AdjacencyMatrixGraph {
    /**
     * 点数量
     */
    private int pointSize;
    /**
     * 边数量
     */
    private int edgeSize;

    private String[] vertexes;
    private int[][] edges;

    public AdjacencyMatrixGraph(int pointSize, int edgeSize) {
        this.pointSize = pointSize;
        this.edgeSize = edgeSize;
        this.vertexes = new String[pointSize];
        this.edges = new int[pointSize][pointSize];
        for(int i=0; i<pointSize; i++) {
            for(int j=0; j<pointSize; j++) {
                this.edges[i][j] = 0;
            }
        }
    }

}
