package demo.structure.tree.parent;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 双亲表示法
 */
@Data
public class Tree<T> {
    /**
     * 根结点
     */
    private Node<T> root;
    /**
     * 结点数组
     */
    private List<Node<T>> nodes;
    /**
     * 结点数量
     */
    private int size;

    public List<Node<T>> getNodes() {
        if(this.nodes == null) this.nodes = new ArrayList<>();
        this.size = this.nodes.size();
        return nodes;
    }

    public void attach(Node<T> node) {
        this.getNodes().add(node);
        this.size++;
    }

    /**
     * 获得某个结点的父结点
     */
    public Node<T> getParent(Node<T> node) {
        if(node == null) return null;
        if(node.getParent() == -1) return null;
        return nodes.get(node.getParent());
    }

    /**
     * 获取某个结点的子结点
     */
    public List<Node<T>> getChildren(Node<T> node) {
        if(node == null) return new ArrayList<>();
        if(node.getFirstChild() == -1) return new ArrayList<>();

        List<Node<T>> result = new ArrayList<>();
        int position = node.getFirstChild();
        while (nodes.get(position).getParent() == node.getIndex()) {
            result.add(nodes.get(position));
            position ++ ;
        }

        return result;
    }

    /**
     * 获取某个结点的子结点
     */
    public List<Node<T>> getChildren2(Node<T> node) {
        if(node == null) return new ArrayList<>();
        if(node.getFirstChild() == -1) return new ArrayList<>();

        List<Node<T>> result = new ArrayList<>();
        int position = node.getFirstChild();
        while (position != -1) {
            result.add(nodes.get(position));
            position = nodes.get(position).getRightSib();
        }
        return result;
    }

}
