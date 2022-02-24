package demo.structure.linear.dul;

public class DulNodeTest {
    public static void main(String[] args) {
        DulNodeLinear<String> linear = new DulNodeLinear<>();
        linear.insert("a");
        linear.insert("b");
        linear.insert("c");
        linear.print(); // a b c
        String ele = linear.get(2);
        System.out.println(ele); // c
        int location = linear.locate("b");
        System.out.println(location); // 1
        System.out.println(linear.length()); // 3
        linear.delete(1);
        linear.print(); // a c
        linear.clear();
        linear.print(); //
        System.out.println(linear.length()); // 0
    }
}
