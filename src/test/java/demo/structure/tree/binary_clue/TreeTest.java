package demo.structure.tree.binary_clue;

import demo.structure.tree.binary_clue.Node;
import demo.structure.tree.binary_clue.Tag;
import demo.structure.tree.binary_clue.Tree;
import org.junit.Before;
import org.junit.Test;

public class TreeTest {
    Tree<String> tree = new Tree<>();
    private Node<String> preNode = null;
    private Node<String> behindNode = null;
    private Boolean needHandle = false;

    private Node<String> getNode(String data) {
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
        N_B.setRChild(N_E);

        N_C.setLChild(N_F);
        N_C.setRChild(N_G);

        N_D.setLChild(N_H);
        N_D.setRChild(N_I);

        N_E.setLChild(N_J);

        tree.setRoot(N_A);
    }

    /**
     * 中序遍历
     */
    @Test
    public void midView() {
        midView(tree.getRoot());
        System.out.println();
    }

    public void midView(Node<String> node) {
        if(node == null) return;
        midView(node.getLChild());
        handle(node);
        midView(node.getRChild());
    }

    public void handle(Node<String> node) {
        System.out.println(node.getData());
        if(needHandle) {
            behindNode.setRChild(node);
            needHandle = false;
        }

        if(node.getLChild() == null) {
            node.setLTag(Tag.Clue);
            node.setLChild(preNode);
        } else {
            node.setLTag(Tag.Link);
        }

        if(node.getRChild() == null) {
            node.setRTag(Tag.Clue);
            behindNode = node;
            needHandle = true;
        } else {
            node.setRTag(Tag.Link);
        }

        done(node);
    }

    private void done(Node<String> node) {
        preNode = node;
    }

}
