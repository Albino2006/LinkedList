/**
 * @author B.Koseler
 */
public class Starter {
    
    public static <err> void stringTest() {
        ListeItf<String> li = new Liste<String>(true);
//        ListeItf<String> li = new Liste<String>(false);
        li.add("A");
        li.add("C");
        li.add("E");
        li.add("B");
        li.add("a");
        li.add("c");
//        li.add(42); // compiler wouldn't accept this
        li.add("b");
        //System.out.println("size = " + li.size());
        try {
            System.out.println("The Item A is contained in the list at:" + li.contains("c"));
        } catch (Exception e) {
            System.out.println("An error happened");
        }
        li.remove("a");
        printList(li);
    }
    
    public static void intTest() {
//        ListeItf<Integer> li = new Liste<Integer>(true);
        ListeItf<Integer> li = new Liste<Integer>(true);
        li.add(42);
        li.add(-1);
        li.add(44);
        li.add(41);
//        li.add("hallo"); // compiler wouldn't accept this
        li.add(43);
        System.out.println("size = " + li.size());
        //System.out.println(li.contains(43));
        printList(li);
    }
    
    public static void listenTest() {
        ListeItf<Long> li1 = new Liste<Long>(true);
        li1.add(23154687L);
        li1.add(654892114555L);
        li1.add(5555555555555L);
        li1.add(12345678945652L);
        ListeItf<Long> li2 = new Liste<Long>(true);
        li2.add(1234567890L);
        li2.add(9876543210L);
        li2.add(44444444444L);
        
        ListeItf<ListeItf<Long>> liLi =  new Liste<>(true);
        liLi.add(li2);
        liLi.add(li1);

        for (ListenElementItf<ListeItf<Long>> li = liLi.getHead(); li != null; li = li.getNext()) {
            printList(li.getItem());
        }
    }
    
    public static void printList(ListeItf<?> li) {
        for(ListenElementItf<?> le = li.getHead(); le != null; le = le.getNext()) {
            System.out.println("item = \"" + le.getItem() + "\"");
        }
    }
    
    public static void main(String[] args) {
        //stringTest();
        //intTest();
        //listenTest();
    }
    
}
