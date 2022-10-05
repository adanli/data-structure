package demo.structure.tree.children_bro;

import lombok.Data;

@Data
public class Node<T> {
    /**
     * 数据
     */
    private T data;
    /**
     * 长子结点
     */
    private Node<T> firstChild;
    /**
     * 右兄弟结点
     */
    private Node<T> rightSib;

    public Node(T data) {
        this.data = data;
    }

    public void attachChild(Node<T> node) {
        if(this.firstChild == null) this.firstChild = node;
        else if(this.firstChild.getRightSib() == null) this.firstChild.setRightSib(node);
        else {
            Node<T> n = this.firstChild;
            while (n.getRightSib() != null) {
                n = n.getRightSib();
            }
            n.setRightSib(node);
        }
    }

}
