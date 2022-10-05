package demo.structure.children_bro;

import demo.structure.tree.children_bro.Node;
import demo.structure.tree.children_bro.Tree;
import org.junit.Before;
import org.junit.Test;

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

        N_A.attachChild(N_B);
        N_A.attachChild(N_C);

        N_B.attachChild(N_D);

        N_C.attachChild(N_E);
        N_C.attachChild(N_F);

        N_D.attachChild(N_G);
        N_D.attachChild(N_H);
        N_D.attachChild(N_I);

        N_E.attachChild(N_J);
        tree.setRoot(N_A);
    }

    @Test
    public void getElement() {
        System.out.println(tree.getElement("E"));
    }

}
