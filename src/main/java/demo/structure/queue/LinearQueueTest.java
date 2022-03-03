package demo.structure.queue;

public class LinearQueueTest {
    public static void main(String[] args) {
        LinearQueue<String> queue = new LinearQueue<>();
        queue.enQueue("a");
        queue.enQueue("b");
        queue.enQueue("c");
        queue.print(); // a b c
        String e = queue.deQueue();
        System.out.println(e); // a
        queue.print(); // 空 b c
        System.out.println(queue.deQueue()); // b
        queue.print(); // 空 空 c
        queue.enQueue("d");
        queue.enQueue("e");
        queue.enQueue("f");
        queue.print(); // 空 空 c d e f
        System.out.println(queue.length()); // 4
        queue.enQueue("g");
        queue.enQueue("h");
        queue.enQueue("i");
        queue.enQueue("j");
        queue.enQueue("k");
        queue.print(); // k 空 c d e f g h i j
        System.out.println(queue.length()); // 9
    }
}
