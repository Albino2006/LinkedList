/**
 * @author B.Koseler
 * @param <T>
 */
public interface ListeItf<T extends Comparable<T>> extends Comparable<ListeItf<T>> {
    public ListenElementItf<T> getHead();
    public boolean add(T item);
    public Integer size();

    public Integer contains(T item);

    public boolean remove(T item);
}
