package demo.structure.graph.adjacency_table;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 邻接表
 */
@Data
public class AdjacencyTableGraph<T> {
    private int vertexSize;
    private int edgeSize;

    private Vertex<T>[] vertices;

    public Boolean[] visited;

    public AdjacencyTableGraph(int vertexSize, int edgeSize) {
        this.vertexSize = vertexSize;
        this.edgeSize = edgeSize;
        this.vertices = new Vertex[vertexSize];
    }

    public void deepTraversal() {
        visited = new Boolean[vertices.length];
        Arrays.fill(visited, false);
        for(int i=0; i<vertices.length; i++) {
            if(visited[i]) continue;
            DFS(i);
        }
    }

    public void DFS(int index) {
        handle(vertices[index]);
        visited[index] = true;
        EdgeNode next = vertices[index].getFirstNode();
        if(next!=null && !visited[next.getData()]) {
            DFS(next.getData());
        }
    }

    private void handle(Vertex<T> vertex) {
        System.out.println(vertex.getData());
    }

    /**
     * 广度优先遍历
     */
    public void breadthTraversal() {
        visited = new Boolean[vertices.length];
        Arrays.fill(visited, false);
        List<Vertex<T>> queue = new ArrayList<>();
        for(int i=0; i<vertices.length; i++) {
            if(visited[i]) continue;
            queue.add(vertices[i]);
            visited[i] = true;

            while (!queue.isEmpty()) {
                Vertex<T> vertex = queue.remove(0);
                handle(vertex);

                EdgeNode node = vertex.getFirstNode();
                while (node != null) {
                    if(!visited[node.getData()]) {
                        queue.add(vertices[node.getData()]);
                        visited[node.getData()] = true;
                    }
                    node = node.getNext();
                }

            }

        }
    }

}
