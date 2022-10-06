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

    /**
     * 添加入度的顶点
     */
    public void attachIn(Integer index) {

    }

}
