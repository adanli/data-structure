package demo.structure.linear.list;

import java.util.Arrays;

/**
 * 线性表-列表
 */
public class LinearList<E> {
    /**
     * 容量
     */
    private int capacity;
    /**
     * 长度
     */
    private int length;
    /**
     * 数据元素
     */
    private Object[] nodes;

    public LinearList(int capacity) {
        if(capacity < 0) throw new RuntimeException("长度必须大于0");
        length = 0;
        this.nodes = new Object[capacity];
    }

    public Boolean isEmpty() {
        return this.nodes==null || this.length==0;
    }

    public void clear() {
        assert this.nodes != null;
        Arrays.fill(nodes, null);
        this.length = 0;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        assert this.nodes != null;
        assert index < capacity;
        return (E)nodes[index];
    }

    public int locateItem(E element) {
        assert this.nodes != null;
        for(int i=0; i<this.length; i++) {
            if(nodes[i].equals(element)) return i;
        }
        return -1;
    }

    public void insert(E element) {
        assert this.nodes != null;
        assert this.length < this.capacity;
        nodes[length] = element;
        length++;
    }

    public void insert(E element, int index) {
        assert this.nodes != null;
        assert this.length < this.capacity;
        for(int i=this.length-1; i>=index; i--) {
            nodes[i+1] = nodes[i];
            if(i == index) {
                nodes[i] = element;
            }
        }
        length++;
    }

    @SuppressWarnings("unchecked")
    public E delete(int index) {
        assert this.nodes != null;
        assert index>=0 && this.length>0 && this.length>=index;

        E element = (E) nodes[index];
        System.arraycopy(nodes, index + 1, nodes, index, this.length - index);
        this.length--;
        return element;
    }

    public int length() {
        assert this.nodes != null;
        return this.length;
    }

}