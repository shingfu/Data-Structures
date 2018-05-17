public class LinkedListStack<E> implements Stack<E> {




    private LinkedList<E> linkedList;

    public LinkedListStack(){
        this.linkedList = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");

        //因为linkList里面有toString的方法，所以不需要用下面方法来写
        res.append(linkedList);
/*

        res.append("LinkedListStack : top [");
        for(int i=0 ; i<linkedList.getSize() ; i ++){
            res.append(linkedList.get(i));
            if(i != linkedList.getSize() - 1)
                res.append(",");
        }
        res.append("] tail");
*/
        return res.toString();
    }



    public static void main(String[] args) {

        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
