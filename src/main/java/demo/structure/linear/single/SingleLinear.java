package demo.structure.linear.single;

/**
 * 单链表
 */
public class SingleLinear<E> {
    /**
     * 数据元素域
     */
    private E element;

    /**
     * 指针域
     */
    private SingleLinear<E> next;

    private SingleLinear() {
        this.element = null;
        this.next = null;
    }

    private SingleLinear(E element) {
        this.element = element;
        this.next = null;
    }

    public Boolean isEmpty() {
        return this.next == null;
    }

    public void clear() {
        next = this.next;
        this.element = null;
        this.next = null;
        while (next != null) {
            next.clear();
        }
    }

    public E get(int index) {
        assert index >= 0;
        if(index == 0) return this.element;
        int i = 1;
        while (i < index) {
            next = this.next;
            assert next != null;

            i++;
        }
        return this.element;
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