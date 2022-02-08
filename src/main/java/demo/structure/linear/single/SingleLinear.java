package demo.structure.linear.single;

/**
 * 单链表
 */
public class SingleLinear<E> {
    private int length = 0;
    private Node<E> element;

    public SingleLinear(int length) {
        assert length > 0;
        this.length = length;
    }

    public void clear() {
        if(this.length == 0) return;
        Node<E> next = element.next;
        element = null;
        while (next != null) {
            element = next;
            next = element.next;
            element = null;
        }

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