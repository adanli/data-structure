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
//    InitList(* List): 初始化操作，建立1个空的线性表L
//    ListEmpty(L): 若线性表为空，返回true，否则返回false
//    ClearList(* L): 将线性表清空
//    GetElem(L, i, *e): 将线性表L的第i个元素返回给e
//    LocateItem(L, e): 在线性表L中查询与e相等的元素，如果查找成功，返回该元素在表中的序号，若失败，返回0
//    ListInsert(*L, i, e): 在线性表L中的第i个位置插入新元素
//    ListDelete(*L, i, *e): 删除线性表L中第i个位置的元素，并用e返回值
//    ListLength(L): 返回线性表L的元素个数