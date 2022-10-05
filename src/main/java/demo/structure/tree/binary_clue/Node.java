package demo.structure.tree.binary_clue;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = {"lChild", "rChild"})
@EqualsAndHashCode(exclude = {"lChild", "rChild"})
public class Node<T> {
    private T data;
    private Tag lTag;

    private Node<T> lChild;
    private Tag rTag;
    private Node<T> rChild;

    public Node(T data) {
        this.data = data;
    }

}
