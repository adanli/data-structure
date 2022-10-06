package demo.structure.graph.neighbor_multi_table;

import lombok.Data;

@Data
public class EdgeNode {
    /**
     * i顶点在顶点数组中的下表
     */
    private int iVex;
    /**
     * j顶点在顶点数组中的下表
     */
    private int jVex;
    /**
     * 跟i相关的边
     */
    private EdgeNode iLink;
    /**
     * 跟j相关的边
     */
    private EdgeNode jLink;

    public EdgeNode(int iVex, int jVex) {
        this.iVex = iVex;
        this.jVex = jVex;
    }
}
