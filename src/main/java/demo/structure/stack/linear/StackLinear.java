package demo.structure.stack.linear;

public class StackLinear<E> {
    private int length = 0;
    /**
     * 头节点
     */
    private StackNode<E> top = null;

    public StackLinear() {}

    public void destory() {
        this.top = null;
    }

    public void clear() {
        StackNode<E> node = this.top;
        while (node != null) {
            node.element = null;
            node = node.next;
            this.length--;
        }
    }

    public Boolean isEmpty() {
        return this.length == 0;
    }

    public E cetTop() {
        return this.top==null?null:this.top.element;
    }

    public void push(E e) {
        StackNode<E> node = new StackNode<>(e);
        node.next = top;
        top = node;
        this.length++;
    }

    public E pop() {
        if(this.top == null) {
            return null;
        }
        StackNode<E> node = this.top;
        top = node.next;
        this.length--;
        return node.element;
    }

    public int length() {
        return this.length;
    }

    public void print() {
        StackNode<E> node = this.top;
        StringBuilder sb = new StringBuilder("");
        while (node != null) {
            sb.append(node.element).append(" ");
            node = node.next;
        }
        System.out.println(sb);
    }

}

//Initstack（*s)：初始化操作，建⽴⼀个空栈S。
//Destroystack（*s)：若栈存在，则销毁它。
//Clearstack（*s）：将栈清空。
//StackEmpty(S)：若栈为空，返回 true，否则返回 false。
//CetTop(S,*e）：若栈存在且⾮空，⽤：返回S的栈顶元素。
//Push (*S,e）：若栈§ 存在，插⼊新元素e到栈S中并成为栈顶元素。
//Pop（*S,*e）：删除栈S中栈顶元素，并⽤e返回其值。
//StackLength(s)：返回栈S的元素个数。
