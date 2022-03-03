package demo.structure.queue;

public class LinearNode<E> {
    protected LinearNode<E> next;
    protected E element;

    protected LinearNode(E element) {
        this.element = element;
    }

}
