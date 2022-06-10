public class ListElement<T> {
    T elem;
    ListElement<T> next;

    public ListElement(T elem, ListElement<T> next) {
        this.elem = elem;
        this.next = next;
    }

    public ListElement(T elem) {
        this.elem = elem;
        this.next=null;
    }
}
