package demo.structure.tree.parent;

import demo.structure.tree.parent.Node;
import demo.structure.tree.parent.Tree;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TreeTest {
    Tree<String> tree = new Tree<>();

    private Node<String> getA() {
        Node<String> A = new Node<>();
        A.setIndex(0);
        A.setData("A");
        A.setParent(-1);
        A.setFirstChild(1);
        A.setRightSib(-1);
        return A;
    }

    private Node<String> getB() {
        Node<String> B = new Node<>();
        B.setIndex(1);
        B.setData("B");
        B.setParent(0);
        B.setFirstChild(3);
        B.setRightSib(2);
        return B;
    }

    private Node<String> getC() {
        Node<String> C = new Node<>();
        C.setIndex(2);
        C.setData("C");
        C.setParent(0);
        C.setFirstChild(4);
        C.setRightSib(-1);
        return C;
    }

    private Node<String> getD() {
        Node<String> D = new Node<>();
        D.setIndex(3);
        D.setData("D");
        D.setParent(1);
        D.setFirstChild(6);
        D.setRightSib(-1);
        return D;
    }

    private Node<String> getE() {
        Node<String> E = new Node<>();
        E.setIndex(4);
        E.setData("E");
        E.setParent(2);
        E.setFirstChild(9);
        E.setRightSib(5);
        return E;
    }

    private Node<String> getF() {
        Node<String> F = new Node<>();
        F.setIndex(5);
        F.setData("F");
        F.setParent(2);
        F.setFirstChild(-1);
        F.setRightSib(-1);
        return F;
    }

    private Node<String> getG() {
        Node<String> G = new Node<>();
        G.setIndex(6);
        G.setData("G");
        G.setParent(3);
        G.setFirstChild(-1);
        G.setRightSib(7);
        return G;
    }

    private Node<String> getH() {
        Node<String> H = new Node<>();
        H.setIndex(7);
        H.setData("H");
        H.setParent(3);
        H.setFirstChild(-1);
        H.setRightSib(8);
        return H;
    }

    private Node<String> getI() {
        Node<String> I = new Node<>();
        I.setIndex(8);
        I.setData("I");
        I.setParent(3);
        I.setFirstChild(-1);
        I.setRightSib(-1);
        return I;
    }

    private Node<String> getJ() {
        Node<String> J = new Node<>();
        J.setIndex(9);
        J.setData("J");
        J.setParent(4);
        J.setFirstChild(-1);
        J.setRightSib(-1);
        return J;
    }

    @Before
    public void init() {
        tree.attach(getA());
        tree.attach(getB());
        tree.attach(getC());
        tree.attach(getD());
        tree.attach(getE());
        tree.attach(getF());
        tree.attach(getG());
        tree.attach(getH());
        tree.attach(getI());
        tree.attach(getJ());
    }

    @Test
    public void getParent() {
        Node<String> parent = tree.getParent(getG());
        System.out.println(parent);
    }

    @Test
    public void getChildren() {
        List<Node<String>> children = tree.getChildren(getG());
        System.out.println(children.stream().map(Node::getData).toList());
    }

    @Test
    public void getChildren2() {
        List<Node<String>> children = tree.getChildren2(getH());
        System.out.println(children.stream().map(Node::getData).toList());
    }

}
