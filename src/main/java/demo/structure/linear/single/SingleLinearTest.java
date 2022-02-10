package demo.structure.linear.single;

public class SingleLinearTest {
    public static void main(String[] args) {
        SingleLinear<String> list = new SingleLinear<>();
        list.insert(0, "a"); // a
        list.insert(0, "b"); // b a
        list.insert(0, "c"); // c b a
        list.insert(1, "d"); // c d b a
        list.insert("e"); // c d b a e
        list.print();
    }

}
