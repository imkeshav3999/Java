import java.util.*;;

public class hashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        // insert
        map.put("india", 120);
        map.put("china", 150);
        map.put("us", 30);
        System.out.println(map);
        map.put("india", 140);
        System.out.println(map);
        // search - lookup
        if (map.containsKey("china")) {
            System.out.println("present");
        } else {
            System.out.println("not present");
        }
        // get
        System.out.println(map.get("india"));
        // for(int val : arr)
        //1.
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        //2.
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }
        //remove
        map.remove("china");
        System.out.println(map);
    }
}
