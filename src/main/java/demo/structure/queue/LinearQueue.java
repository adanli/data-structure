package demo.structure.queue;

import javax.sound.sampled.Line;

/**
 * 循环队列
 * 链路存储结构
 */
public class LinearQueue<E> {
//    private LinearNode<E> node;
    private LinearNode<E> front = null; // 头指针
    private LinearNode<E> rear = null; // 尾指针

    public LinearQueue() {
        rear = front = null;
    }

    public void clear() {
        if(front == null) return;
        LinearNode<E> node = front;
        while (node != null) {
            node.element = null;
            node = node.next;
        }

    }

    public boolean isEmpty() {
        return front == null;
    }

    // 尾插
    public void enQueue(E element) {
        LinearNode<E> node = new LinearNode<>(element);
        if(front == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    // 头取
    public E deQueue() {
        if(front == null) return null;
        E value = front.element;
        if(front == rear) {
            rear = front.next;
        }
        front = front.next;
        return value;
    }

    public int length() {
        LinearNode<E> element = front;
        int i = 0;
        while (element != null) {
            i++;
            element = element.next;
        }
        return i;
    }

    public void print() {
        LinearNode<E> element = front;
        while (element != null) {
            System.out.print(element.element + " ");
            element = element.next;
        }
        System.out.println();
    }

}

//InitQueue（*Q）：初始化操作，建⽴⼀个空队列 Q。
//DestroyQueue（*Q）：若队列存在，则销毁它。
//ClearQueue(*Q）：将队列Q清空。
//QueueEmpty(Q)：若队列Q为空，返回true，否则返回 false。
//GetHead(Q,*e）：若队列Q 存在且⾮空，⽤e返回队列Q的队头元素。
//EnQueue(*Q,e）：若队列Q 存在，插⼊新元素e到队列Q中并成为队尾元素。
//DeQueue(*Q,*e）：删除队列Q中队头元素，并⽤e返回其值。
//QueueLength(Q)：返回队列Q的元素个数