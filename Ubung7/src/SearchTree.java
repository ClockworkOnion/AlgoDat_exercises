import com.sun.source.tree.Tree;

import java.sql.Array;
import java.util.ArrayList;

public class SearchTree <T extends Comparable>{
    TreeElement root;

    public SearchTree(TreeElement root) {
        this.root = root;
    }

    public SearchTree() {
    }

    public TreeElement search(TreeElement root, T key){
        if (root==null || root.key.equals(key)){
            return root;
        }
        if (key.compareTo(root.key)<0) return search(root.left,key);
        else return search(root.right,key);
    }

    public static TreeElement TreeMinimum(TreeElement root){
        while (root.left != null) root=root.left;
        return root;
    }

    public static TreeElement TreeMaximum(TreeElement root){
        while (root.right != null) root=root.right;
        return root;
    }

    public TreeElement<T> Father(TreeElement element){
        return element.parent;
    }

    public TreeElement<T> Right(TreeElement element){
        return element.left;
    }

    public TreeElement<T> Left(TreeElement element){
        return element.right;
    }

    public static void TreeInsert(SearchTree T,TreeElement elem){
        TreeElement y=T.root;
        while(y != null ){
            elem.parent=y;
            if (elem.key.compareTo(y.key)<0){
                y=y.left;
            }else y=y.right;
        }
        if (elem.parent==null){
            T.root=elem;
        }else {
            if (elem.key.compareTo(elem.parent.key)<0){
                elem.parent.left=elem;
            }else {
                elem.parent.right=elem;
            }
        }
    }


    public static TreeElement TreeSuccessor(TreeElement r){
        if (r.right != null){
            return TreeMinimum(r.right);
        }
        TreeElement y=r.parent;
        while (y != null && r==y.right){
            r=y;
            y=r.parent;
        }
        return y;
    }

    public void TreeDelete(SearchTree T,TreeElement elem){
        TreeElement y;
        if (elem.left == null || elem.right == null){
            y=elem;
        }else y=TreeSuccessor(elem);
        TreeElement x;
        if (y.left != null) x=y.left;
        else x=y.right;
        if (x != null) x.parent=y.parent;
        if (y.parent == null) T.root=x;
        else if (y==y.parent.left) y.parent.left=x;
        else y.parent.right=x;
        if (y!=elem) elem.key=y.key;
    }

    ArrayList<TreeElement> results = new ArrayList<TreeElement>();
    public ArrayList<TreeElement> toSortedArrayList() {
        results = new ArrayList<TreeElement>();
        toListRecursive(this.root);
        return results;
    }

    private void toListRecursive(TreeElement elem) {
        if (elem != null) {
            toListRecursive(elem.left);
            results.add(elem);
            toListRecursive(elem.right);
        }
    }

    public static void InorderTreeWalk(TreeElement elem){
        if (elem != null){
            InorderTreeWalk(elem.left);
            System.out.println(elem.key);
            InorderTreeWalk(elem.right);
        }
    }

    public static void main(String[] args) {
//        //root
//        TreeElement<Integer> e1=new TreeElement<>(18);
//
//
//        //right
//        TreeElement<Integer> e2=new TreeElement<>(11,e1,null,null);
//        TreeElement<Integer> e3=new TreeElement<>(6,e2,null,null);
//        TreeElement<Integer> e4=new TreeElement<>(6,e2,null,null);


        ///root
        SearchTree<Integer> tree=new SearchTree<>(new TreeElement(18,null,null,null));
        TreeInsert(tree,new TreeElement(11));
        TreeInsert(tree,new TreeElement(6));
        TreeInsert(tree,new TreeElement(15));
        TreeInsert(tree,new TreeElement(14));
        TreeInsert(tree,new TreeElement(33));
        TreeInsert(tree,new TreeElement(27));
        TreeInsert(tree,new TreeElement(21));
        TreeInsert(tree,new TreeElement(45));
//        tree.TreeDelete(tree, new TreeElement(27));
        System.out.println("Tree Printing : ");
        InorderTreeWalk(tree.root);

        System.out.println("As list:");
        ArrayList<TreeElement> list = tree.toSortedArrayList();
        list.forEach(x -> System.out.println(x.key));


//        System.out.println(tree.search(tree.root,33).key);

    }

}
