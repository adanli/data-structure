package demo.structure.tree.parent;

import lombok.Data;

@Data
public class Node<T> {
    /**
     * 结点所在的数组下标
     */
    private int index;
    private T data;
    /**
     * 父结点下标
     */
    private int parent;
    /**
     * 长子结点下标
     */
    private int firstChild;
    /**
     * 右侧兄弟结点下标
     */
    private int rightSib;

}
