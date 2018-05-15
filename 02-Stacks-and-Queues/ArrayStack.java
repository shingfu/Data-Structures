
//基于动态数据的
public class ArrayStack<E> implements Stack<E>{

    private Array<E> arrayStack;

    public ArrayStack() {
        arrayStack = new Array<>(10);
    }

    public ArrayStack(int capacity){
        arrayStack = new Array<>(capacity);
    }

    @Override
    public void push(E e) {
        arrayStack.addLast(e);
    }

    @Override
    public E pop() {
        return arrayStack.removeLast();
    }

    @Override
    public E peek() {
        return arrayStack.getLast();
    }

    @Override
    public int getSize() {
        return arrayStack.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arrayStack.isEmpty();
    }


    //getCapacity()不是stack接口的一部分，是因为stack接口和我们栈的具体实现是无关的，只有当我们使用动态数组来实现这个栈的时候才存在容积这个概念
    public int getCapacity(){
        return arrayStack.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack:[");
        for(int i=0 ; i < arrayStack.getSize(); i++){
            res.append(arrayStack.get(i));
            if(i != arrayStack.getSize()-1)
                res.append(",");
        }
        res.append("]top");
        return res.toString();
    }


}
