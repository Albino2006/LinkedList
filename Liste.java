/**
 * @author B.Koseler
 * @param <T>
 */
public class Liste<T extends Comparable<T>> implements ListeItf<T> {

    private ListenElementItf<T> head;
    private final Boolean asc; // null ==> unsorted, asc ==> ascending, !asc ==> descending

    public Liste() {
        this.asc = null; // unsorted List
    }

    public Liste(boolean asc) {
        this.asc = asc;
    }

    @Override
    public ListenElementItf getHead() {
        return head; //returns head
    }

    @Override
    public boolean add(T newItem) {
        ListenElementItf<T> newElem = new ListenElement(newItem);
        if (head == null) {
            head = newElem; //if head == null, the newElem becomes the head
        } else {
            if (asc == null) {
                getLastElem().setNext(newElem);
            } else {
                ListenElementItf<T> prev = null;
                for (ListenElementItf<T> currElem = head; currElem != null; currElem = currElem.getNext()) {
                    int cRes = newItem.compareTo(currElem.getItem());
                    if (cRes == 0)
                        return false; // do not add newItem as it is already in the list
                    if ( (asc && (cRes < 0)) || (!asc && (cRes > 0)) )
                        break;
                    prev = currElem;
                }
                if (prev == null) { // newElem needs to be placed before head 
                    newElem.setNext(head);
                    head = newElem;
                } else { // else newElem needs to be placed after prev
                    newElem.setNext(prev.getNext());
                    prev.setNext(newElem);
                }
            }
        }
        return true; // added
    }

    @Override
    public Integer size() {
        int size = 0;
        for (ListenElementItf<T> currElem = head; currElem != null; currElem = currElem.getNext(), size++) {
        }
        return size;
    }

    @Override
    public int compareTo(ListeItf<T> other) {
        return size().compareTo(other.size());
    }

    private ListenElementItf<T> getLastElem() {
        ListenElementItf<T> lastElem;
        for (ListenElementItf<T> currElem = lastElem = head; currElem != null; currElem = currElem.getNext()) {
            lastElem = currElem;
        }
        return lastElem;
    }
    
   
    @Override
    public Integer contains(T newItem) {
        ListenElementItf<T> newElem = new ListenElement(newItem);
        Integer i = 0;
        for(ListenElementItf<T> currElem = head; currElem != null; currElem = currElem.getNext()) {
            if(currElem.compareTo(newElem) == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public boolean remove(T remItem) {
        ListenElementItf<T> prevElem = new ListenElement(null);
        ListenElementItf<T> remElem = new ListenElement(remItem);
        for(ListenElementItf<T> currElem = head; currElem != null; prevElem = currElem,currElem = currElem.getNext()) {
            if(currElem.compareTo(remElem) == 0) {
                prevElem.setNext(currElem.getNext());
                currElem = null;
                break;
            }
        }
        return true;
    }

}
