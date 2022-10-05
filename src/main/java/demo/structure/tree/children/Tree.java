package demo.structure.tree.children;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 孩子表示法
 */
@Data
public class Tree<T> {
    /**
     * 表头数组
     */
    private List<Header<T>> nodes;
    private int size;

    public List<Header<T>> getNodes() {
        if(this.nodes == null) this.nodes = new ArrayList<>();
        this.size = this.nodes.size();
        return nodes;
    }

    public void attach(Header<T> header) {
        this.getNodes().add(header);
        header.setIndex(size);
        this.size++ ;
    }

    public List<Node<T>> getChildren(T data) {
        List<Node<T>> result = new ArrayList<>();
        for (Header<T> header : nodes) {
            if (header.getData().equals(data)) {
                Node<T> node = header.getFirstChild();
                while (node != null) {
                    result.add(node);
                    node = node.getNext();
                }
                break;
            }
        }

        return result;
    }

    public T getParent(T data) {
        for(Header<T> header: nodes) {
            if(header.getData().equals(data)) {
                if(header.getParent() == -1) return null;
                return nodes.get(header.getParent()).getData();
            }
        }
        return null;
    }

}
