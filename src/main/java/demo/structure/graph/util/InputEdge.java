package demo.structure.graph.util;

import lombok.Data;

@Data
public class InputEdge {
    private String from;
    private String to;
    private Integer weight;

    public InputEdge(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public InputEdge(String from, String to, Integer weight) {
        this(from, to);
        this.weight = weight;
    }

}
