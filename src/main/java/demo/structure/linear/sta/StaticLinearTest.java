package demo.structure.linear.sta;

public class StaticLinearTest {
    public static void main(String[] args) {
        StaticLinear staticLinear = new StaticLinear(10);
        staticLinear.print();
        staticLinear.insert(new char[]{'h', 'e', 'l', 'l', 'o'});
        staticLinear.print();
        staticLinear.delete('e');
        staticLinear.print();
        staticLinear.insert(new char[]{'a', 'b'});
        staticLinear.print();
        staticLinear.delete('h');
        staticLinear.print();
    }
}
