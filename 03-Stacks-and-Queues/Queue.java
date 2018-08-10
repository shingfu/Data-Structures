public interface Queue<E> {

    boolean isEmpty();     //判断是否为空

    void enqueue(E e);     //入队

    E dequeue();           //出队

    E getFront();          //获得队首元素值

    int getSize();        //获得队列元素个数

}
