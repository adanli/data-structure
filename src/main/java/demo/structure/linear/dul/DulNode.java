package demo.structure.linear.dul;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = {"prev", "next"})
@EqualsAndHashCode(exclude = {"prev", "next"})
public class DulNode<E> {
    protected E element;

    /**
     * 后继节点
     */
    protected DulNode<E> next;

    /**
     * 前驱节点
     */
    protected DulNode<E> prev;

    public DulNode() {}

    public DulNode(E e) {
        this.element = e;
    }
}
