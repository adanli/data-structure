package demo.structure.tree.children_bro;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 孩子兄弟表示法
 */
@Data
public class Tree<T> {
    private Node<T> node;

    public void setRoot(Node<T> root) {
        this.node = root;
    }

    public Node<T> getElement(T data) {
        if(node == null) return null;

        List<Node<T>> queue = new ArrayList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node<T> n = queue.remove(0);
            if(n.getData().equals(data)) return n;
            if(n.getRightSib() != null) queue.add(n.getRightSib());
            if(n.getFirstChild() != null) queue.add(n.getFirstChild());
        }
        return null;
    }

}
