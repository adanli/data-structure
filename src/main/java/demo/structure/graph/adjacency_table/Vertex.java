package demo.structure.graph.adjacency_table;

import lombok.Data;

@Data
public class Vertex<T> {
    /**
     * 顶点内容
     */
    private T data;
    /**
     * 第一个结点
     */
    private EdgeNode firstNode;

    public Vertex(T data) {
        this.data = data;
    }

    public void attachNode(int index) {
        if(firstNode == null) this.firstNode = new EdgeNode(index);
        else {
            EdgeNode n = new EdgeNode(index);
            n.setNext(firstNode);
            this.firstNode = n;
        }
    }

    public void attachNode(EdgeNode node) {
        if(node == null) return;
        if(this.firstNode == null) this.firstNode = node;
        else {
            node.setNext(firstNode);
            this.firstNode = node;
        }
    }

}
