package demo.structure.graph.edge_set_array;

import lombok.Data;

@Data
public class EdgeNode {
    private int begin;
    private int end;
    private int weight;

    public EdgeNode(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    public EdgeNode(int begin, int end, int weight) {
        this.begin = begin;
        this.end = end;
        this.weight = weight;
    }

}
