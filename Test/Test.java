public class Test {
    public static  void main(String[] args) {
/*        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i=0 ; i<6 ; i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        System.out.println(linkedList.remove(3));
        System.out.println(linkedList.toString());*/

        LinkedListStack linkedListStack = new LinkedListStack();
        for(int i=0 ; i<5; i++){
            linkedListStack.push(i);
            System.out.println(linkedListStack);
        }
        System.out.println("此时栈的容量为"+linkedListStack.getSize());
        System.out.println("栈头元素为："+linkedListStack.peek());
        linkedListStack.pop();
        System.out.println(linkedListStack);
    }


}
