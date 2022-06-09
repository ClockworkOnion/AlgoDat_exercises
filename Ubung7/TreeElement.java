import com.sun.source.tree.Tree;

public class TreeElement<T extends Comparable> {
    T key;
    TreeElement parent;
    TreeElement right;
    TreeElement left;

    public TreeElement(T key, TreeElement parent, TreeElement right, TreeElement left) {
        this.key = key;
        this.parent = parent;
        this.right = right;
        this.left = left;
    }

    public TreeElement(T key) {
        this.key = key;
    }
}
