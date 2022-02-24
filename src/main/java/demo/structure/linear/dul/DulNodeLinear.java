package demo.structure.linear.dul;

import demo.structure.linear.single.Node;

/**
 * 双向链表
 */
public class DulNodeLinear<E> {
    private int length = 0;
    private DulNode<E> node;

    public DulNodeLinear() {}

    public Boolean isEmpty() {
        return this.length == 0;
    }

    public void clear() {
        if(this.length == 0) return;

        DulNode<E> element = node;
        while (this.length > 0) {
            element = node.next;
            node.next = null;
            node.prev = null;
            node.element = null;
            node = element;
            this.length--;
        }
        System.out.println(this.node);
    }

    public E get(int index) {// a b c
        return this.getNode(index).element;
    }

    //a b c
    //0 1 2
    private DulNode<E> getNode(int index) {
        assert index>=0 && this.length>index;
        if(index == 0) return node;
        int i = 0;
        DulNode<E> element = node;
        while (i<index) {
            element = element.next;
            i++;
        }
        return element;
    }

    public int locate(E e) {
        assert e!=null;

        int index = 0;
        DulNode<E> element = this.node;
        while (index < length) {
            if(element.element.equals(e)) return index;
            element = element.next;
            index++;
        }
        return -1;
    }

    // a b c
    // 0-1 2
    public void insert(int index, E e) {
        assert index>=0 && index<=length;
        DulNode<E> insertNode = new DulNode<>(e);

        // 如果是第一次
        if(this.node == null) {
            this.node = insertNode;
            insertNode.prev = insertNode;
            insertNode.next = insertNode;
        } else {
            // 找到位置
            DulNode<E> element = getNode(index);
            element.prev.next = insertNode;
            insertNode.prev = element.prev;
            element.prev = insertNode;
            insertNode.next = element;
        }

        this.length++;
    }

    /**
     * 尾插
     * @param e
     * a b c
     * 0 1 2
     */
    public void insert(E e) {
        /*DulNode<E> insertNode = new DulNode<>(e);
        if(node == null) {
            node = insertNode;
            insertNode.prev = node;
        } else {
            insertNode.prev = node.prev;
            insertNode.next = node;
            node.prev = insertNode;
        }
        this.length++;*/
        this.insert(length, e);
    }

    // a b c
    // 0 1 2
    public E delete(int index) {
        assert index>=0 && index<this.length;
        // 找到这个元素
        DulNode<E> element = getNode(index);
        if(this.length == 1) {
            this.node = null;
        } else {
            element.next.prev = element.prev;
            element.prev.next = element.next;
        }

        this.length--;
        return element.element;
    }

    public int length() {
        return this.length;
    }

    public void print() {
        DulNode<E> ele = this.node;
        StringBuilder sb = new StringBuilder("");
        int i=0;
        while (i < length) {
            sb.append(ele.element).append(" ");
            ele = ele.next;
            i++;
        }
        System.out.println(sb.toString());
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
