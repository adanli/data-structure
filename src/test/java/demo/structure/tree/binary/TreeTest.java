package demo.structure.tree.binary;

import demo.structure.tree.binary.Node;
import demo.structure.tree.binary.Tree;
import org.junit.Before;

public class TreeTest {
    Tree<String> tree = new Tree<>();

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
    }

}
