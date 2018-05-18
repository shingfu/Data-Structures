
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
        return size == 0;
    }


    @Override
    public int getSize() {
        return size;
    }


    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }

        size ++;


    }


    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");

        Node retNode = head;
        head = head.next;
        retNode.next = null;

        if(head ==null)
            tail = null;
        size --;
        return  retNode.e;
    }


    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return head.e;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while(cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args){

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
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
