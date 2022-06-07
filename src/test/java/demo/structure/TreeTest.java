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
    public void pre() {

    }
}
