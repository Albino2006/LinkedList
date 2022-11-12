/**
 * @author B.Koseler
 * @param <T>
 */
public class ListenElement<T extends Comparable<T>> implements ListenElementItf<T> {
    
    private final T item;
    private ListenElementItf<T> next;
    
    public ListenElement(T item) {
        this.item = item;
    }

    @Override
    public T getItem() {
        return item;
    }

    @Override
    public ListenElementItf<T> getNext() {
        return next;
    }

    @Override
    public void setNext(ListenElementItf<T> next) {
        this.next = next;
    }
    
    @Override
    public int compareTo(ListenElementItf<T> other) {
        return item.compareTo(other.getItem());
    }
    
}
