public class Test {
    public static void main(String[] args) {

        Array<Integer> array = new Array<>();

        ArrayStack<Integer> arrayStack = new ArrayStack<>(10);
        for(int i=0; i<5; i++){
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        arrayStack.pop();
        System.out.println(arrayStack);
    }
}
