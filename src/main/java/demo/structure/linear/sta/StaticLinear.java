package demo.structure.linear.sta;

public class StaticLinear {
    private final int maxSize;
    private final Node[] nodes;

    public StaticLinear(int maxSize) {
        this.maxSize = maxSize;
        this.nodes = new Node[maxSize];
        int i=0;
        while (i < maxSize) {
            Node element = new Node();
            element.item = '\0';
            if(i == 0) {
                element.cur = 1;
            } else if(i == maxSize-1) {
                element.cur = 0;
            } else {
                element.cur = i+1;
            }
            nodes[i] = element;
            i++;
        }
    }

    public boolean isEmpty() {
        return nodes[0].cur==0 && nodes[maxSize-1].cur==1;
    }

    public void clear() {
        int i=0;
        while (i < maxSize) {
            nodes[i].item = '\0';
            nodes[i].cur = i + 1;
            i++;
        }
        nodes[0].cur = 1;
        nodes[maxSize-1].cur = 0;
    }

    public void insert(char[] item) {
        assert item!=null && item.length>0;
        // 插入的位置
        int startPosition = nodes[0].cur;
        for (int i=0; i<item.length; i++) {
            Node ele = new Node();
            // 元素插入当前位置
            ele.item = item[i];
            nodes[startPosition] = ele;
            // 如果是最后一个数据，cur = 0，并设置node的位置；否则找下一个
            if(i == item.length-1) {
                ele.cur = 0;
                nodes[0].cur = ++startPosition;
            } else {
                // 寻找下一个位置
                for (int j = startPosition + 1; j < maxSize; j++) {
                    if (nodes[j].item == '\0') {
                        startPosition = j;
                        ele.cur = startPosition;
                        break;
                    }
                }
            }
        }

        if(nodes[maxSize-1].cur == 0) {
            nodes[maxSize-1].cur = 1;
        }

    }

    public void delete(char c) {
        for(int i=nodes[maxSize-1].cur; i<maxSize; i++) {
            if(nodes[i].item == c) {
                nodes[i].item = '\0';
                // 如果删除的是第一个元素，需要更新nodes[max-1]的cur
                if(i == 1) {
                    nodes[maxSize - 1].cur = 2;
                }
                // 如果删除元素的位置小于备用列表的起点，更新nodes[0]的cur
                if(i < nodes[0].cur) {
                    nodes[0].cur = i;
                }
            }
        }

    }

    public void print() {
        StringBuilder sb1 = new StringBuilder();
        for(int i=0; i<maxSize; i++) {
            sb1.append(nodes[i].item).append(" ");
        }
        System.out.println(sb1);
        StringBuilder sb2 = new StringBuilder();
        for(int i=0; i<maxSize; i++) {
            sb2.append("【item: ").append(nodes[i].item).append(";").append("cur: ").append(nodes[i].cur).append("】 ");
        }
        System.out.println(sb2);
    }

}

//InitList(* List): 初始化操作，建立1个空的线性表L
//ListEmpty(L): 若线性表为空，返回true，否则返回false
//ClearList(* L): 将线性表清空
//GetElem(L, i, *e): 将线性表L的第i个元素返回给e
//LocateItem(L, e): 在线性表L中查询与e相等的元素，如果查找成功，返回该元素在表中的序号，若失败，返回0
//ListInsert(*L, i, e): 在线性表L中的第i个位置插入新元素
//ListDelete(*L, i, *e): 删除线性表L中第i个位置的元素，并用e返回值
//ListLength(L): 返回线性表L的元素个数