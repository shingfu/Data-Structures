public interface Queue<E> {

    //判断是否为空
    boolean isEmpty();

    //出队
    E dequeue();

    //入队
    void enqueue(E e);

    //获得队首元素值
    E getFront();

    //获得队列元素个数
    int getSize();

}
