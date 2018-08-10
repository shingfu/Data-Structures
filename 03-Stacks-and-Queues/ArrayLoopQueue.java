public class ArrayLoopQueue<E> implements Queue<E>{
    private E[] data;
    private int size;
    private int front;
    private int tail;

    //构造函数
    public ArrayLoopQueue(int capacity){
        data = (E[]) new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public ArrayLoopQueue(){
        this(10);
    }

    //判断队列是否为空
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    //获得容量
    public int getCapacity(){
        return data.length - 1;
    }

    //入队
    @Override
    public void enqueue(E e) {

        if((tail+1)%data.length == front)                //检查是否需要扩容
            resize((data.length-1)*2);

        data[tail] = e;
        tail = (tail+1) % data.length;
        size ++ ;

    }

    //出队
    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("cannot dequeue from an empty queue");

        E res =  data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size -- ;

        if(size == getCapacity() / 4 && size / 2 != 0){     //检查是否需要减容
            resize(getCapacity()/2 );
        }
        return res;
    }

    //获得对头
    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("this queue is empty");
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    //扩(减)容
    public void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];
        for(int i=0 ; i<size ; i++){                                  //遍历循环队列方式1，与toString方法中的遍历一样
            newData[i] = data[(i+front )% data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }




}
