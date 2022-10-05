package demo.structure.binary;

import demo.structure.tree.binary.Node;
import demo.structure.tree.binary.Tree;
import lombok.ToString;
import org.junit.Before;
import org.junit.Test;

/**
 * 二叉树遍历
 */
public class TreeSelectTest {
    Tree<String> tree = new Tree<>();

    private <T> Node<T> getNode(T data) {
        return new Node<>(data);
    }

    @Before
    public void init() {
        Node<String> N_A = getNode("A");
        Node<String> N_B = getNode("B");
        Node<String> N_C = getNode("C");
        Node<String> N_D = getNode("D");
        Node<String> N_E = getNode("E");
        Node<String> N_F = getNode("F");
        Node<String> N_G = getNode("G");
        Node<String> N_H = getNode("H");
        Node<String> N_I = getNode("I");
        Node<String> N_J = getNode("J");

        N_A.setLChild(N_B);
        N_A.setRChild(N_C);

        N_B.setLChild(N_D);

        N_C.setLChild(N_E);
        N_C.setRChild(N_F);

        N_D.setLChild(N_G);
        N_D.setRChild(N_H);

        N_E.setRChild(N_I);

        tree.setRoot(N_A);
    }

    /**
     * 前序遍历
     */
    @Test
    public void preView() {
        preView(tree.getRoot());
    }

    private <T> void preView(Node<T> node) {
        if(node == null) return;
        handle(node);
        preView(node.getLChild());
        preView(node.getRChild());
    }

    /**
     * 中序遍历
     */
    @Test
    public void midView() {
        midView(tree.getRoot());
    }

    private <T> void midView(Node<T> node) {
        if(node == null) return;
        midView(node.getLChild());
        handle(node);
        midView(node.getRChild());
    }

    /**
     * 后序遍历
     */
    @Test
    public void behindView() {
        behindView(tree.getRoot());
    }

    public <T> void behindView(Node<T> node) {
        if(node == null) return;
        behindView(node.getLChild());
        behindView(node.getRChild());
        handle(node);
    }

    private <T> void handle(Node<T> node) {
        System.out.println(node.getData());
    }

}
