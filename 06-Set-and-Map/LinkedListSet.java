//基于链表所存储的类型并不要求具有可比性，这是线性数据结构的一个特点
public class LinkedListSet<E> implements Set<E> {
    private LinkedList01<E> list;

    public LinkedListSet(){
        list = new LinkedList01<>();
    }

    @Override
    public void add(E e) {
        if(!list.contains(e))
            list.addFirst(e);      // O(1)
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e) ;
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
