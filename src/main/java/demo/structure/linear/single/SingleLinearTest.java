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

        list.delete(0);
        list.print(); // d b a e

        list.delete(2); // d b e
        list.print();

        System.out.println(list.length());

        list.clear();
        list.print();
        System.out.println(list.length());

    }

}
