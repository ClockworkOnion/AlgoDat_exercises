import com.sun.source.tree.Tree;


import java.util.ArrayList;

public class BalancedSearchTree <T extends Comparable>{

    TreeElement root;
    final static double alpha=0.3;
    public static ArrayList arrayList=new ArrayList<>();

    public BalancedSearchTree(TreeElement root) {
        this.root = root;
    }



    public static double calculateAll(TreeElement elem){
        double c =0;
        if (elem == null) return 0;
        else c= 1+calculateHeight(elem.left)+calculateHeight(elem.right);
        return c;
    }

    public static double calculateHeight(TreeElement elem){
        if (calculateAll(elem)==0) return 0;
        return calculateAll(elem);
    }



    public static <T extends Comparable> TreeElement search(TreeElement root, T key){
        if (root==null || root.key.equals(key)){
            return root;
        }
        if (key.compareTo(root.key)<0){

            return search(root.left,key);
        }
        else {
            return search(root.right,key);
        }
    }

    public static int calculateWay(TreeElement element,TreeElement elem){
        if (search(element,elem.key)!=null){
            if (element==null || element.key.equals(elem.key)){
                return 1;
            }
            if (elem.key.compareTo(element.key)<0){

                return 1+calculateWay(element.left,elem);
            }
            else {

                return 1+calculateWay(element.right,elem);
            }
        }
        else return -1;
    }

    //calculate gho
    public static double calculateBalance(TreeElement elem){
        // if (elem==null) return 1/(calculateHeight(elem)+1);
        return (calculateAll(elem.left)+1)/(calculateHeight(elem)+1);
    }

    //usual tree insert
    public static void TreeInsert(BalancedSearchTree T, TreeElement elem){
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

    //usual tree delete ans successor and minimum and maximum
    public static TreeElement TreeMinimum(TreeElement root){
        while (root.left != null) root=root.left;
        return root;
    }

    public static TreeElement TreeMaximum(TreeElement root){
        while (root.right != null) root=root.right;
        return root;
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

    public static void TreeDelete(BalancedSearchTree T, TreeElement elem){
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


    //balanced inserting
    public static void TreeInsertBalanced(BalancedSearchTree T, TreeElement elem){
        TreeInsert(T,elem);
        int k=calculateWay(T.root,search(T.root,elem.key));
        elem=search(T.root,elem.key);
        elem.level=k;
        RebalanceTree(T,elem,k);
    }

    private static void RebalanceTree(BalancedSearchTree t, TreeElement elem, int level) {
        for (int i=level;i>0;i--){
            if (calculateBalance(elem)<alpha){
                if (calculateBalance(elem.right)<=(1/(2-alpha))){
                    LeftRotate(t,search(t.root, elem.key));

                }else {
                    DoubleLeftRotate(t,search(t.root, elem.key));
                }
            }
            if (calculateBalance(elem)>1-alpha){
                if (calculateBalance(elem.left)>=(1-1/(2-alpha))){
                    RightRotate(t,search(t.root, elem.key));
                }
                else {
                    DoubleRightRotate(t,search(t.root, elem.key));
                }
            }
            elem=elem.parent;
        }
    }

    private static void DoubleRightRotate(BalancedSearchTree t, TreeElement elem) {
        LeftRotate(t,elem.left);
        RightRotate(t,elem);

    }

    private static void RightRotate(BalancedSearchTree t, TreeElement elem) {
        if (elem.left!=null) {
            TreeElement y = elem.left;
            elem.left = y.right;
            if (y.right != null) y.right.parent = elem;
            y.parent = elem.parent;
            if (elem.parent == null) t.root = y;
            else if (elem == elem.parent.right) elem.parent.right = y;
            else elem.parent.left = y;
            y.right = elem;
            elem.parent = y;
        }
    }

    private static void DoubleLeftRotate(BalancedSearchTree t, TreeElement elem) {
        RightRotate(t,elem.right);
        LeftRotate(t,elem);

    }

    private static void LeftRotate(BalancedSearchTree t, TreeElement elem) {
        if (elem.right!=null){
            TreeElement y=elem.right;
            elem.right=y.left;
            if (y.left != null) y.left.parent=elem;
            y.parent=elem.parent;
            if (elem.parent==null) t.root=y;
            else if (elem==elem.parent.left) elem.parent.left=y;
            else elem.parent.right=y;
            y.left=elem;
            elem.parent=y;
        }
    }
    //balanced deleting
    public static void DeleteAndBalance(BalancedSearchTree t, TreeElement elem){
        if (elem == null) return;
        TreeDelete(t,elem);
        int k=calculateWay(t.root,search(t.root,elem.key));
        elem=search(t.root,elem.key);
        elem.level=k;
        RebalanceTree(t,elem,k);
    }

    public static <T> void toSortedArrayList(TreeElement elem){
        if (elem != null){
            toSortedArrayList(elem.left);
            arrayList.add((T)elem.key);
            toSortedArrayList(elem.right);
        }

    }

    public static <T> ArrayList<T> toSortedArrayList1(TreeElement elem){
        toSortedArrayList(elem);
        return arrayList;

    }


    public static void printBinaryTree(TreeElement root, int space, int height)
    {
        if (root == null) {
            return;
        }
        space += height;
        printBinaryTree(root.right, space, height);
        System.out.println();
        for (int i = height; i < space; i++) {
            System.out.print(' ');
        }
        System.out.print(root.key);
        System.out.println();
        printBinaryTree(root.left, space, height);
    }
    public static void main(String[] args) {
        BalancedSearchTree<Integer> tree=new BalancedSearchTree<>(new TreeElement<Integer>(2,null,null,null));
        TreeInsertBalanced(tree,new TreeElement(10));
        TreeInsertBalanced(tree,new TreeElement(5));
        TreeInsertBalanced(tree,new TreeElement(3));
        TreeInsertBalanced(tree,new TreeElement(6));
        TreeInsertBalanced(tree,new TreeElement(9));
//        TreeInsertBalanced(tree,new TreeElement(10));
//        TreeInsertBalanced(tree,new TreeElement(15));
//        TreeInsertBalanced(tree,new TreeElement(11));
        //TreeInsertBalanced(tree,new TreeElement(17));

        //RightRotate(tree,search(tree.root, 14));
        //LeftRotate(tree,search(tree.root, 8));
//        TreeInsertBalanced(tree,new TreeElement(9));
//        TreeInsertBalanced(tree,new TreeElement(17));
        //DeleteAndBalance(tree,search(tree.root, 14));
        //System.out.println(calculateBalance(search(tree.root, 2)));
        //DoubleLeftRotate(tree,search(tree.root, 11));
        //printBinaryTree(tree.root,10,10);
        toSortedArrayList1(tree.root);
        arrayList.forEach(x-> System.out.println(x));
        //System.out.println(calculateWay( tree.root,search(tree.root, 10)));
        //System.out.println(tree.root.key);
    }
}
