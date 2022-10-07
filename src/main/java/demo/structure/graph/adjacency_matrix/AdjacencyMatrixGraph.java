package demo.structure.graph.adjacency_matrix;

import lombok.Data;

import java.util.Arrays;

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
    /**
     * 顶点是否被访问过
     */
    private Boolean[] visited;

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

    /**
     * 深度遍历
     */
    public void deepTraversal() {
        visited = new Boolean[vertexes.length];
        Arrays.fill(visited, false);
        for(int i=0; i<vertexes.length; i++) {// 遍历所有顶点，每个顶点按深度优先遍历
            if(visited[i]) continue;
            DFS(i);
        }
    }

    private void DFS(int index) {
        visited[index] = true;
        handle(vertexes[index]);
        for(int j=0; j<edges[index].length; j++) {
            if(edges[index][j]==0 || visited[j]) continue; // 说明没有构成边
            DFS(j);
        }
    }

    public void handle(String vertex) {
        System.out.println(vertex);
    }

}
