package demo.structure.queue;

import java.util.Arrays;

/**
 * 循环队列
 * 顺序存储结构
 */
public class CircularQueue<E> {
    private int capacity;
    private int front;
    private int rear;
    private Object[] arr;

    public CircularQueue(int capacity) {
        assert capacity > 0;
        this.capacity = capacity;
        this.arr = new Object[capacity];
        this.front = 0;
        this.rear = 0;
    }

    public void destroy() {
        this.capacity = -1;
        this.arr = null;
    }

    public void clear() {
        assert this.arr != null;
        Arrays.fill(arr, null);
    }

    /**
     * 空的情况
     * 1. rear = front + 1
     * 2. front = capacity && rear = 0
     * @return
     */
    public boolean isEmpty() {
        return rear==front+1 || (front==this.capacity&&this.rear==0);
    }

    @SuppressWarnings("unchecked")
    public E getHead() {
        if(this.isEmpty()) return null;
        return (E)arr[front];
    }

    /**
     * 判断队列是否满了
     * 1. rear - front = capacity-1
     * 2. front - rear = 1
     * @param
     */
    public boolean isFull() {
        return rear-front==capacity-1 || front-rear==1;
    }

    public void enQueue(E element) {
        if(this.isFull()) throw new RuntimeException("队列已满");
        if(rear < this.capacity-1) {
            arr[rear++] = element;
        } else {
            arr[rear] = element;
            rear = 0;
        }
    }

    @SuppressWarnings("unchecked")
    public E deQueue() {
        if(this.isEmpty()) throw new RuntimeException("队列空");
        Object element = arr[front];
        arr[front] = null;
        if(front < this.capacity - 1) {
            if(front != this.rear-1) {
                this.front++;
            }
        } else {
            if(this.rear != 0) {
                this.front = 0;
            }
        }
        return (E)element;
    }

    // length = 5, front = 0, rear = 4 -> length = 4
    // length = 5, front = 2, rear = 1 -> length = 4
    // length = 5, front = 1, rear = 3 -> length = 2
    public int length() {
        if(this.rear > this.front) return this.rear - this.front;
        return this.capacity - (this.front - this.rear);
    }

    public void print() {
        for(int i=0; i<capacity; i++) {
            System.out.print(arr[i] + " ");
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