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

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i=0 ; i<array.getSize() ; i++){
            res.append(array.get(i));
            if(i!= array.getSize()-1){
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}
