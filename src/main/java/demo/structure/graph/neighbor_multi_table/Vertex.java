package demo.structure.graph.neighbor_multi_table;

import lombok.Data;

@Data
public class Vertex<T> {
    private T data;
    private EdgeNode firstEdge;

    public Vertex(T data) {
        this.data = data;
    }

}
