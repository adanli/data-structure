package demo.structure.linear.list;

public class LinearListTest {
    public static void main(String[] args) {
        LinearList<String> list = new LinearList<>(10);
        list.insert("1");
        list.insert("2");
        list.insert("3");
        print(list); // 123
        list.insert("4", 1);
        print(list); // 1423
        list.delete(1);
        print(list); // 123
        System.out.println(list.locateItem("3")); // 2
        System.out.println(list.isEmpty()); // false
        list.clear();
        System.out.println(list.isEmpty()); // true
    }

    private static <E> void print(LinearList<E> list) {
        for(int i=0; i<list.length(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

}
