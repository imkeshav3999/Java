public class LL {
    Node head;
    private int size;
    LL(){
        this.size = 0;
    }
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }
    //ADD - FIRST
    public void addFirst(String data){
        //if there is no node
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        //if a list already exists, if head is not null
        newNode.next = head;
        head = newNode;
    }
    //ADD - LAST
    public void addLast(String data){
        //if there is no node
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        //traverse the LL
        Node currNode = head;//no manipulation on head
        while (currNode.next != null){
            currNode = currNode.next;//update
        }
        currNode.next = newNode;
    }

    //PRINT
    public void printList(){
        if (head == null){
            System.out.println("list is empty");
        }
        Node currNode = head;
        while (currNode != null){
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }
    //DELETE
    public void deleteFirst(){
        if (head == null){
            System.out.println("list is empty");
        }
        size--;
        head = head.next;
    }
    public void deleteLast(){
        if (head == null){
            System.out.println("list is empty");
        }
        size--;
        if (head.next == null){
            head = null;
            return;
        }
        Node secondLast = head;
        Node lastNode = head.next;
        while (lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }
    //SIZE
    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        LL list = new LL();//obj of the class
        list.addFirst("a");
        list.addFirst("is");
        list.printList();
        list.addLast("list");
        list.printList();
        list.addFirst("this");
        list.printList();
        list.deleteFirst();
        list.printList();
        list.deleteLast();
        list.printList();
        System.out.println(list.getSize());
    }
}
