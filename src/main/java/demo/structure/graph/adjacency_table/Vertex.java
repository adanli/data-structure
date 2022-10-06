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
        if(firstNode == null) {
            firstNode = new EdgeNode(index);
        } else if(firstNode.getNext() == null) {
            firstNode.setNext(new EdgeNode(index));
        } else {
            EdgeNode n = firstNode.getNext();
            while (n.getNext() != null) {
                n = n.getNext();
            }
            n.setNext(new EdgeNode(index));
        }
    }

}
