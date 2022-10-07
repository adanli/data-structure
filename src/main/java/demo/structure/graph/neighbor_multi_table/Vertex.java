package demo.structure.graph.neighbor_multi_table;

import lombok.Data;

@Data
public class Vertex<T> {
    private T data;
    private EdgeNode firstEdge;

    public Vertex(T data) {
        this.data = data;
    }

    public void attachIEdge(EdgeNode node) {
        if(this.firstEdge == null) {
            this.firstEdge = node;
        } else {
            node.setILink(firstEdge);
            this.firstEdge = node;
        }
    }

    public void attachJEdge(EdgeNode node) {
        if(this.firstEdge == null) this.firstEdge = node;
        else {
            node.setJLink(firstEdge);
            this.firstEdge = node;
        }
    }

}
