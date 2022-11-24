import java.util.HashSet;
import java.util.Iterator;;
public class hashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        // insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        // size
        System.out.println("size of the set: " + set.size());
        //print all elements
        System.out.println(set);
        // search - contains
        if (set.contains(1)) {
            System.out.println("set contains 1");
        }
        if (!set.contains(6)) {
            System.out.println("does not contains 6");
        }
        // remove
        set.remove(1);
        if (!set.contains(1)) {
            System.out.println("deleted 1");
        }
        //iterator
        Iterator it = set.iterator();   
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
