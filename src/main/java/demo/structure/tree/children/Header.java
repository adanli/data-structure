package demo.structure.tree.children;

import lombok.Data;

/**
 * 表头结点
 */
@Data
public class Header<T> {
    /**
     * 数据内容
     */
    private T data;
    /**
     * 元素在数组中的位置
     */
    private int index;
    /**
     * 孩子结点的根结点
     */
    private Node<T> firstChild;
    /**
     * 父结点在数组中的位置
     */
    private int parent;

    public Header(T data, int parent) {
        this.data = data;
        this.parent = parent;
    }

    public void attach(Node<T> node) {
        if(this.firstChild == null) this.firstChild = node;
        else if(this.firstChild.getNext() == null) this.firstChild.setNext(node);
        else {
            Node<T> n = this.firstChild;
            while (n.getNext() != null) {
                n = n.getNext();
            }
            n.setNext(node);
        }
    }

}
