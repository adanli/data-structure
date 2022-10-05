package demo.structure.tree.children;

import lombok.Data;

/**
 * 孩子结点
 */
@Data
public class Node<T> {
    /**
     * 在表头数组中的下标位置
     */
    private int child;
    /**
     * 指向下一个孩子结点（父结点的孩子结点）
     */
    private Node<T> next;

    public Node(int child) {
        this.child = child;
    }
}
