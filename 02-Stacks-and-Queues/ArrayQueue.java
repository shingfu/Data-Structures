//基于动态数组的
public class ArrayQueue<E> implements Queue<E>{

    private Array<E> array;

    //构造函数
    public ArrayQueue(int capacity){
        array = new Array<E>(capacity);
    }

    public ArrayQueue(){
        array = new Array<E>();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity(){
        return array.getCapacity();
    }


}
