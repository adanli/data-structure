package demo.structure.stack.linear;

import lombok.Data;

/**
 * 单链
 * @param <E>
 */
@Data
public class StackNode<E> {
    protected E element;
    protected StackNode<E> next;

    public StackNode(E element) {
        this.element = element;
    }
}
