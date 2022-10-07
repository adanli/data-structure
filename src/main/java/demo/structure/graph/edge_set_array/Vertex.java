package demo.structure.graph.edge_set_array;

import lombok.Data;

@Data
public class Vertex<T> {
    private T data;

    public Vertex(T data) {
        this.data = data;
    }

}
