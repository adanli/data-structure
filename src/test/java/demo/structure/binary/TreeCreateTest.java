package demo.structure.binary;

import demo.structure.tree.binary.Node;
import demo.structure.tree.binary.Tree;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 构建二叉树
 */
public class TreeCreateTest {
    String[] input;
    Tree<String> tree = new Tree<>();

    @Before
    public void init() {
        input = new String[]{"A", "B", "#", "D", "#", "#", "C", "#", "#"};
    }

    @Test
    public void create() {
        Node<String> root = new Node<>(null);
        tree.setRoot(root);
        preCreate(root, Arrays.stream(input).iterator());
        System.out.println();
    }

    /**
     * 通过前序创建
     */
    public <T> void preCreate(Node<String> node, Iterator<String> iterator) {
        if(!iterator.hasNext()) return;
        String s = iterator.next();
        if(s.equals("#")) {
            node.setData(null);
        } else {
            node.setData(s);
            Node<String> lChild = new Node<>(null);
            Node<String> rChild = new Node<>(null);
            node.setLChild(lChild);
            node.setRChild(rChild);
            preCreate(node.getLChild(), iterator);
            preCreate(node.getRChild(), iterator);
        }
    }

}
