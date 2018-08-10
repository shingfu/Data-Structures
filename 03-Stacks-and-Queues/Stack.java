
public interface Stack<E> {

    boolean isEmpty();    //栈是否为空

    void push(E e);       // 入栈

    E pop();               // 出栈

    E peek();             // 查看栈顶元素

    int getSize();        // 查看栈里有多少值

}
