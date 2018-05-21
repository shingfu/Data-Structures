//基于二分搜索树的集合
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    public BSTSet() {
        bst = new BST();
    }

    @Override
    public void add(E e) {
        bst.add(e);     //对重复的元素不理会
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
