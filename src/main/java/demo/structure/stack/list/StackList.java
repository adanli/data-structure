package demo.structure.stack.list;

/**
 * 栈
 */
public class StackList<E> {
    private int length;
    private Object[] array;
    /**
     * 当前栈针的位置
     */
    private int top = -1;

    public StackList(int size) {
        assert size > 0;
        this.length = size;
        array = new Object[length];
    }

    public void destroy() {
        this.array = null;
        this.length = 0;
    }

    public void clear() {
        while (top >=0 ) {
            E e = pop();
            System.out.println("clear: " + e);
        }
    }

    public Boolean isEmpty() {
        return top == 0;
    }

    @SuppressWarnings("unchecked")
    public E cetTop() {
        assert this.length > 0;
        if(top != 0) return (E)array[top];
        return null;
    }

    /**
     * 压栈
     * @param e
     */
    public void push(E e) {
        assert this.length>0 && this.top<this.length-1;
        array[++top] = e;
    }

    /**
     * 弹栈
     */
    @SuppressWarnings("unchecked")
    public E pop() {
        assert this.length>0 && this.top>=0;
        return (E)array[top--];
    }

    public int length() {
        return top+1;
    }

    public void print() {
        for(int i=0; i<length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
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
