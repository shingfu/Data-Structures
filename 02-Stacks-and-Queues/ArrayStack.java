
//基于动态数组的
public class ArrayStack<E> implements Stack<E>{

    private Array<E> array;

    public ArrayStack() {
        array = new Array<>(10);
    }

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    //getCapacity()不是stack接口的一部分，是因为stack接口和我们栈的具体实现是无关的，只有当我们使用动态数组来实现这个栈的时候才存在容积这个概念
    public int getCapacity(){
        return array.getCapacity();
    }



}
