import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {     //类型E必须具有可比较性
    private class Node{
        public E e;
        public Node left , right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }


    private Node root;
    private int size;


    public BST(){
        root = null;
        size = 0;
    }


    public int size(){
        return size;
    }


    public boolean isEmpty(){
        return size == 0;
    }


    // 向二分搜索树中添加新的元素e
    public void add(E e){
        root = add(root ,e);
    }
    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node,E e){
        if(node == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0){
            node.left = add(node.left , e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right ,e);
        }

        return node;
    }



    // 查询元素
    public boolean contains( E e){
        return contains(root , e);
    }
    public boolean contains(Node node , E e){
        if(node == null)
            return false;

        if(e.compareTo(node.e) == 0)
            return  true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left , e);
        else   //e.compareTo(node.e) > 0
            return contains(node.right ,e);

    }



    // 二分搜索树的前序遍历 --- 应用：应用最多
    public void preOrder(){
        preOrder(root);
    }
    // 前序遍历以node为根的二分搜索树，递归算法
    private void preOrder(Node node ){
        if(node == null)
            return ;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);

       /*
        if(node != null){
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
        */
    }



    // 二分搜索树的非递归前序遍历
    // 利用栈结构（Stack）
    public void preOrderNR(){
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }



    // 二分搜索树的中序遍历 --- 应用：排序 等
    public void inOrder(){
        inOrder(root);
    }
    // 中序遍历以Node为根的二分搜索树，递归算法
    public void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }



    // 二分搜索树的后序遍历 --- 应用：为二分搜索树释放内存（先把节点的孩子节点释放完再释放节点）等
    public void postOrder(){
        postOrder(root);
    }
    // 后序遍历以Node为根的二分搜索树，递归算法
    public void postOrder(Node node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }



    // 二分搜索树的层序遍历（广度优先遍历主要用于搜索策略上）
    // 利用队列结构（Queue）
    public void levelOrder(){
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while( !queue.isEmpty() ){
            Node node = queue.remove();
            System.out.println(node.e);

            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);

        }
    }



    //寻找二分搜索树的最小元素
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        return minimum(root).e;
    }
    //返回以nodfe为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;

        return minimum(node.left);

    }


    //寻找二分搜索树的最大元素
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        return maximum(root).e;
    }
    //返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node){
        if(node.right == null)
            return node;

        return maximum(node.right);
    }



    // 从二分搜索树中删除最小值所在的节点，返回最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }
    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size -- ;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }



    //从二分搜索树中删除最大值所在的节点，返回最大值
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }
    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size -- ;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }



    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }
    // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e){

        if( node == null )
            return null;

        if( e.compareTo(node.e) < 0 ){
            node.left = remove(node.left , e);
            return node;
        }
        else if(e.compareTo(node.e) > 0 ){
            node.right = remove(node.right, e);
            return node;
        }
        else{   // e.compareTo(node.e) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);     //removeMin(node.right) 返回的是删除了后继节点后 新的node.right这歌节点
            size ++ ;
            successor.left = node.left;
            node.left = node.right = null;
            size --;

            return successor;
        }
    }








    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for(int num: nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();
        System.out.println();
        bst.preOrderNR();
        System.out.println();

        bst.inOrder();
        System.out.println();
        bst.postOrder();

        System.out.println();
        bst.levelOrder();
    }


}
