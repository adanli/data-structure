package demo.structure.graph.cross_link_table;

import lombok.Data;

/**
 * 边结点
 */
@Data
public class EdgeNode {
    /**
     * 弧起点在顶点表的下标
     */
    private int tailVex;
    /**
     * 弧终点在顶点表的下标
     */
    private int headVex;

    /**
     * 指向起点相同的下一条边
     */
    private EdgeNode tailLink;
    /**
     * 指向终点相同的下一条边
     */
    private EdgeNode headLink;
}
