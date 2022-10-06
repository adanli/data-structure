package demo.structure.tree.children;

import demo.structure.tree.children.Header;
import demo.structure.tree.children.Node;
import demo.structure.tree.children.Tree;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * 孩子表示法
 */
public class TreeTest {
    Tree<String> tree = new Tree<>();

    private Header<String> getHeader(String data, int parent) {
        return new Header<>(data, parent);
    }

    public Node<String> getNode(int index) {
        return new Node<>(index);
    }

    @Before
    public void init() {
        Header<String> H_A = getHeader("A", -1);
        Header<String> H_B = getHeader("B", 0);
        Header<String> H_C = getHeader("C", 0);
        Header<String> H_D = getHeader("D",1);
        Header<String> H_E = getHeader("E",2);
        Header<String> H_F = getHeader("F",2);
        Header<String> H_G = getHeader("G",3);
        Header<String> H_H = getHeader("H",3);
        Header<String> H_I = getHeader("I",3);
        Header<String> H_J = getHeader("J",4);
        tree.attach(H_A);
        tree.attach(H_B);
        tree.attach(H_C);
        tree.attach(H_D);
        tree.attach(H_E);
        tree.attach(H_F);
        tree.attach(H_G);
        tree.attach(H_H);
        tree.attach(H_I);
        tree.attach(H_J);

        Node<String> N_B = getNode(H_B.getIndex());
        Node<String> N_C = getNode(H_C.getIndex());
        Node<String> N_D = getNode(H_D.getIndex());
        Node<String> N_E = getNode(H_E.getIndex());
        Node<String> N_F = getNode(H_F.getIndex());
        Node<String> N_G = getNode(H_G.getIndex());
        Node<String> N_H = getNode(H_H.getIndex());
        Node<String> N_I = getNode(H_I.getIndex());
        Node<String> N_J = getNode(H_J.getIndex());

        H_A.attach(N_B);
        H_A.attach(N_C);
        H_B.attach(N_D);
        H_C.attach(N_E);
        H_C.attach(N_F);
        H_D.attach(N_G);
        H_D.attach(N_H);
        H_D.attach(N_I);
        H_E.attach(N_J);

    }

    @Test
    public void getChildren() {
        List<Node<String>> list = tree.getChildren("C");
        System.out.println(
                list.stream().map(node -> tree.getNodes().get(node.getChild()).getData()).toList()
        );
    }

    @Test
    public void getParent() {
        System.out.println(tree.getParent("G"));
    }

}
