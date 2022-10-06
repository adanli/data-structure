package demo.structure.graph.cross_link_table;

import lombok.Data;

/**
 * 顶点
 */
@Data
public class Vertex<T> {
    private T data;
    /**
     * 入边表头指针
     */
    private EdgeNode firstIn;

    /**
     * 出边表头指针
     */
    private EdgeNode firstOut;

    public Vertex(T data) {
        this.data = data;
    }

    public void attachTail(Integer from, Integer to) {
        EdgeNode n = new EdgeNode();
        n.setTailVex(from);
        n.setHeadVex(to);
        if(this.firstOut == null) this.firstOut = n;
        else {
            n.setTailLink(this.firstOut);
            this.firstOut = n;
        }
    }

    public void attachHeader(EdgeNode node) {
        if(this.firstIn == null) this.firstIn = node;
        else {
            node.setHeadLink(this.firstIn);
            this.firstIn = node;
        }
    }

}
