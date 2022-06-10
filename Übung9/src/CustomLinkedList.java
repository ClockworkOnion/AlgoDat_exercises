import java.util.LinkedList;
import java.util.List;

public class CustomLinkedList<T>{
    ListElement<T> root;

    public CustomLinkedList(ListElement<T> root) {
        this.root = root;
    }

    public CustomLinkedList() {
        this.root=null;
    }

    public void ListInsertAtFirst(T elem){
        root=new ListElement<T>(elem,root);
    }

    public void ListDelete(T key){
        if (root==null) return;
        else if (root.elem.equals(key)){
            root=root.next;
            return;
        }
        ListElement y=root;
        ListElement prev=null;
            while (y!=null){
                if (y.elem.equals(key)){
                    prev.next=y.next;
                    return;
                }
                prev=y;
                y=y.next;
            }

    }

        public ListElement ListSearch(T key){
        if (root==null) return null;
        else {
            ListElement y=root;
            while (y!=null){
                if (y.elem.equals(key)) return y;
                else y=y.next;
            }
        }
        return null;
    }

    public void printList(CustomLinkedList list){
        ListElement y=list.root;
        while (y!=null){
            System.out.print(y.elem+"--->");
            y=y.next;
        }
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> list=new CustomLinkedList<>();

        for (int i = 0; i <20 ; i++) {
            list.ListInsertAtFirst(i);
        }
        list.ListDelete(0);
        list.printList(list);
    }


}
