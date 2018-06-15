/**
       分析动态数组的时间复杂度
       增 ：O(n）
       删 ：O(n)
       改 ：已知索引O(1);未知索引O(n)
       查 ：已知索引O(1);未知索引O(n)

      情景1：addLast和removeLast时启动了resize    -------    均摊复杂度分析
      情景2：addLast和removeLast交替执行          -------    复杂度的震荡
             出现问题原因：removeLast 时 resize 过于着急 （Eager);
             解决方案：当 size==capacity/4 时，才capacity 减半（Lazy）
 */


//动态数组
public class Array<E> {
    private E[] data;
    private int size;   //指向值为空（0）的第一个元素




    //有参构造，输入数组的容量capacity构造Array
    public Array(int capacity){
        data = (E[])new Object[capacity];                                  // new E[capacity]不行，历史遗留问题     Object是任意类的父类
    }

    //无参构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);                                  // 调用上面的有参构造方法
    }

    //有参构造函数，放入一个数组
    public Array(E[] arr){
        data = (E[])new Object[arr.length];
        for(int i = 0 ; i < arr.length ; i ++)
            data[i] = arr[i];
        size = arr.length;
    }




    //获取数组中的元素个数
    public int getSize(){
        return size;
    }


    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }


    //判断数组是否为空
    public boolean isEmpty(){
        return size==0;
    }

    /*--------------------------------------------------------  增  ------------------------------------------------------------*/

    //在index个位置插入一个新元素e ---- O(n/2) = O(n)
    public void add(int index,E e){

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed ");

        if(size == data.length)
            resize(2 * data.length);

        for(int i = size-1 ; i >= index ; i --)
            data[i+1] =data[i];

        data[index] = e;
        size ++;
    }


    //向数组的最后一个位置添加一个新元素 ---- O(1)
    public void addLast(E e){
        /*      if(size == data.length)
                    throw new IllegalArgumentException("AddLast failed . Array is full.");

                data[size] = e;
                size ++;
        */
        add(size,e);
    }

    //向数组的第一个位置添加一个新元素 ---- O(n)
    public void addFirst(E e){
        add(0,e);
    }

    /*--------------------------------------------------------  删  ------------------------------------------------------------*/

    //从数组中删除index位置的元素，返回删除的元素
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed");

        E ret = data[index];
        for(int i=index ; i<size-1 ;i++){
            data[i] = data[i+1];
        }
        size --;                                                                   // 使用泛型后，数组里面存的都是类对象的引用，所以此时的data[size]还指着一个引用（loitering object），所以此时它不会被垃圾回收机制自动回收，
        data[size] = null;                                                        // 所以这个语句使得data[size]不与其他任何对象相关联了，java的自动回收机制将很快速的将它回收起来

        if(size == data.length / 4 /*2*/ && data.length / 2 != 0)               // 减容（/4 避免复杂度震荡）
            resize(data.length / 2);
        return ret;
    }


    //从数组中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }


    //从数组中删除最后一个元素，返回删除的元素
    public E removeLast(){
        return remove(size-1);
    }


    //从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    /*--------------------------------------------------------  改  ------------------------------------------------------------*/

    //修改index索引位置的元素为e  ---- O(1)
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed ");
        data[index] = e;
    }

    /*--------------------------------------------------------  查  ------------------------------------------------------------*/

    //获取index索引位置的元素
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed ");
        return data[index];
    }


    //获取最后一个元素
    public E getLast(){
        return get(size - 1);
    }


    //获取第一个元素
    public E getFirst(){
        return get(0);
    }


    //查找数组中是否有元素e
    public boolean contains(E e){
        for(int i=0 ; i<size ; i++){
            if(data[i].equals(e))                                          //类对象用 equals（值比较） == （引用比较）
                return true;
        }
        return false;
    }


    //查找数组元素中e所在的索引，如果不存在元素额，则返回-1
    public int find(E e){
        for(int i=0; i<size ; i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }


    //堆中使用
    public void swap(int i, int j){

        if(i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal.");

        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d ,capacity = %d \n",size,data.length));
        res.append("[");
        for(int i=0 ; i<size; i++) {
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    //数组扩(减) 容
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for(int i=0 ; i<size ; i++)
            newData[i] = data[i];

        data = newData;

    }

}


