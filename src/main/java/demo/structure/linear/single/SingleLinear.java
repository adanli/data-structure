package demo.structure.linear.single;

/**
 * 单链表
 */
public class SingleLinear<E> {
    private int length = 0;
    private Node<E> element;

    /*public SingleLinear(int length) {
        assert length > 0;
        this.length = length;
    }*/
    public SingleLinear() {

    }

    public void clear() {
        if(this.length == 0) return;
        Node<E> next = element.next;
        this.element = null;
        while (next != null) {
            element = next;
            next = element.next;
            element = null;
        }
        this.length = 0;
    }

    public E get(int index) {
        assert index>=0 && index<this.length;
        if(index == 0) return this.element.item;
        int i = 1;
        Node<E> ele = element;
        while (i <= index) {
            ele = this.element.next;
            i++;
        }
        return ele.item;
    }

    public int locate(E item) {
        assert item!=null && this.length>0;
        if(this.element.item.equals(item)) return 0;
        int index = 1;
        Node<E> ele = this.element.next;
        while (ele != null) {
            if(ele.item.equals(item)) return index;
            index++;
            ele = ele.next;
        }
        return index;
    }

    public void insert(int index, E e) {
        assert index>=0 && index<=this.length;
        Node<E> insertItem = new Node<>();
        insertItem.item = e;

        if(index == 0) {
            insertItem.next = this.element;
            this.element = insertItem;
            this.length++;
            return;
        }

        // 找到index位置前面的1个
        int i=1;
        Node<E> ele = this.element;
        while (i < index - 1) {
            ele = ele.next;
            i++;
        }
        insertItem.next = ele.next;
        ele.next = insertItem;
        this.length++;

    }

    public void insert(E e) {
        Node<E> insertItem = new Node<>();
        insertItem.item = e;
        if(this.element == null) {
            this.element = insertItem;
        } else {
            Node<E> ele = this.element;
            while (ele.next != null) {
                ele = ele.next;
            }
            ele.next = insertItem;
        }

        this.length++;
    }

    public E delete(int index) {
        assert index>=0 && index<this.length;

        Node<E> ele = this.element;
        this.length--;

        if(index == 0) {
            if(this.length == 1) {
                this.element = null;
                return ele.item;
            } else {
                this.element = this.element.next;
                return ele.item;
            }
        }

        int i = 0;
        while (i < index-1) {
            ele = ele.next;
            i++;
        }
        Node<E> next = ele.next;
        ele.next = next.next;
        return next.item;

    }

    public int length() {
        return this.length;
    }

    public void print() {
        Node<E> ele = this.element;
        StringBuilder sb = new StringBuilder("");
        while (ele != null) {
            sb.append(ele.item).append(" ");
            ele = ele.next;
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