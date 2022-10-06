package demo.structure.graph.adjacency_table;

import lombok.Data;

/**
 * 边结点
 */
@Data
public class EdgeNode {
    /**
     * 结点在数组中的下标
     */
    private int data;
    /**
     * 权重
     */
    private int weight;

    /**
     * 下一个结点, 表示顶点直接连接的顶点
     */
    private EdgeNode next;

    public EdgeNode(int data) {
        this.data = data;
    }

}
