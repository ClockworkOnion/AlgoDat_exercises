public class TreeElement<T extends Comparable> {
    T key;
    TreeElement parent;
    TreeElement right;
    TreeElement left;
    int level;
    double balance;

    public TreeElement(T key) {
        this.key = key;
        this.parent = null;
        this.right = null;
        this.left = null;
    }

    public TreeElement(T key, TreeElement parent, TreeElement right, TreeElement left) {
        this.key = key;
        this.parent = parent;
        this.right = right;
        this.left = left;
    }

    public TreeElement(T key, TreeElement parent, TreeElement right, TreeElement left, double balance) {
        this.key = key;
        this.parent = parent;
        this.right = right;
        this.left = left;
        this.balance = balance;
    }
}
