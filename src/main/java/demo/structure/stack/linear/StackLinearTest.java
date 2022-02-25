package demo.structure.stack.linear;

import demo.structure.stack.list.StackList;

public class StackLinearTest {
    public static void main(String[] args) {
        StackLinear<String> stack = new StackLinear<>();
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
