package demo.structure.stack.list;

public class StackListTest {
    public static void main(String[] args) {
        StackList<String> stack = new StackList(10);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.print(); // a b c
        System.out.println(stack.length()); // 3
        String c = stack.pop();
        System.out.println(c); // c
        stack.push("d");
        stack.print(); // a b d
        stack.clear();
        System.out.println(stack.length()); // 0
    }
}
