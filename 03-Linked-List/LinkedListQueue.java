
//基于链表的队列
public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        private E e;
        private Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this.e = e;
            this.next = null;
        }

        public Node(){
            this.e = null;
            this.next = null;
        }

        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;


    //构造函数
    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E getFront() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    public void enququeFirst(E e){
        Node node = new Node(e);
        node.next = head.next;
        head = node;


    }
}
