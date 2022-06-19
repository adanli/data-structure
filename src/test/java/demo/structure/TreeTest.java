package demo.structure;

import demo.structure.tree.Node;
import org.junit.Before;
import org.junit.Test;

public class TreeTest {
    private Node<String> rootNode = null;

    @Before
    public void construct() {
        Node<String> A = new Node<>("A");
        Node<String> B = new Node<>("B");
        Node<String> C = new Node<>("C");
        Node<String> D = new Node<>("D");
        Node<String> E = new Node<>("E");
        Node<String> F = new Node<>("F");
        Node<String> G = new Node<>("G");
        Node<String> H = new Node<>("H");
        Node<String> I = new Node<>("I");

        A.setLeftNode(B);
        A.setRightNode(C);

        B.setLeftNode(D);

        C.setLeftNode(E);
        C.setRightNode(F);

        D.setLeftNode(G);
        D.setRightNode(H);

        E.setRightNode(I);

        rootNode = A;
    }

    @Test
    public void test() {
        behind(rootNode);
    }

    /**
     * 前序遍历
     * @param node
     */
    public void pre(Node<String> node) {
        System.out.print(node.getData());
        if(node.getLeftNode() != null) pre(node.getLeftNode());
        if(node.getRightNode() != null) pre(node.getRightNode());
    }

    /**
     * 中序遍历
     * @param node
     */
    public void mid(Node<String> node) {
        if(node.getLeftNode() != null) mid(node.getLeftNode());
        System.out.print(node.getData());
        if(node.getRightNode() != null) mid(node.getRightNode());
    }

    /**
     * 后序遍历
     * @param node
     */
    public void behind(Node<String> node) {
        if(node.getLeftNode() != null) behind(node.getLeftNode());
        if(node.getRightNode() != null) behind(node.getRightNode());
        System.out.print(node.getData());
    }

    /**
     * 层序遍历
     * @param node
     */
    public void level(Node<String> node) {

    }

}
