import java.util.*;


public class arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        //add elements
        list.add(0);
        list.add(1);
        list.add(2);
        System.out.println(list);
        //get
        int element = list.get(0);//pass the index
        System.out.println(element);
        //add element in between O(n)
        list.add(3, 3);
        System.out.println(list);
        //set
        list.set(0, 5);
        System.out.println(list);
        //delete
        list.remove(3);
        System.out.println(list);

        //size
        int size = list.size();
        System.out.println(size);
        //loops
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //sort
        Collections.sort(list);
        System.out.println(list);

    }


}
