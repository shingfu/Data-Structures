import org.omg.SendingContext.RunTime;

public class LoopQueueyy<E> implements Queue<E> {
    private E[] arr;
    private int front;
    private int tail;
    private int size;

    public LoopQueueyy(int capacity){
        arr = (E[]) new Object[capacity+1];
    }
    public LoopQueueyy(){
        arr = (E[]) new Object[10];
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("此队列是空的");
        E e = arr[front];
        arr[front] = null;
        front ++;
        return e;
    }

    @Override
    public void enqueue(E e) {
        if((tail+1)/arr.length != front){
            tail ++;
            arr[front] = e;
        }
    }

    @Override
    public E getFront() {
        E e = arr[front];
        return e;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void resize(int newCapacity){
        E[] newArr = (E[]) new Object[newCapacity+1];
        for(int i=front ; i<= (tail+1)/arr.length ; i=(i+1)/arr.length){
            newArr[i] = arr[i];
        }
    }
}
