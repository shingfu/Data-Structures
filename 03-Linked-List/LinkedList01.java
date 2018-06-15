/**
        分析动态数组的时间复杂度
        增 ：O(n）      -------------->  如果只对链表头进行操作：O(1)
        删 ：O(n)       -------------->  如果只对链表头进行操作：O(1)         ========》   栈
        改 ：O(n)       不用改操作
        查 ：O(n)       -------------->  只查链表头的元素：O(1)

        链表是动态的，不会造成内存空间的浪费

 */



public class LinkedList01<E> {

    //内部类
    private class Node{
        private E e;
        private Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;    //获取中间值或者根据索引查值，就用此虚拟头结点,否者直接把第一个元素定义为头结点
    private int size;

    //构造函数
    public LinkedList01(){
        dummyHead = new Node();
        size = 0;
    }

    //获得链表中的元素个数
    public int getSize(){
        return  size;
    }

    //返回链表元素是否为空
    public boolean isEmpty(){
        return size == 0;
    }


    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）  //因为通常选择链表，就不会选择索引了,后面涉及到索引的都不是常用的
    // 此方法关键在于定位index的前一个元素
    public void add(int index, E e){

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead;

        for(int i = 0 ; i < index  ; i ++)    //因为dummyHead是0索引前一个元素，所以要定位到索引为index的前一个元素，就要遍历index
            prev = prev.next;

//      Node node = new Node(e);
//      node.next = prev.next;
//      prev.next = node;

        prev.next = new Node(e, prev.next);
        size ++;

    }

    // 在链表头添加新的元素e
    public void addFirst(E e){
        add(0,e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e){
        add(size, e);
    }

    // 获得链表的第index(0-based)个位置的元素
    public E get(int index){

        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur = dummyHead.next;
        for(int i=0 ; i<index ; i++)
            cur = cur.next;

        return cur.e;
    }

    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    // 查找链表中是否有元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 修改链表的第index(0-based)个位置的元素为e
    public void set(int index,E e){

        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = dummyHead.next;
        for(int i=0 ; i<index ; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    public E remove(int index){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }

        Node prev = dummyHead;
        for(int i=0; i<index ; i++)
            prev = prev.next;

        Node delNote = prev.next;
        prev.next = delNote.next;
        delNote.next = null;
        size -- ;

        return delNote.e;
    }


    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }


    // 从链表中删除元素e
    public void removeElement(E e){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

}
