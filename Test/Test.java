public class Test {
    public static void main(String[] args) {

        Array<Integer> array = new Array<>();
        for(int i = 0 ; i < 10 ; i++){
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1,100);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(5);
        System.out.println(array);
    }
}
