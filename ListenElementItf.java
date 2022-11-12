/**
 * @author B.Koseler
 * @param <T>
 */
public interface ListenElementItf<T extends Comparable<T>> extends Comparable<ListenElementItf<T>> {
    public T getItem();
    public ListenElementItf<T> getNext();
    public void setNext(ListenElementItf<T> next);
}
