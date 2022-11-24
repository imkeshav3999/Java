public class reverseLL {
    Node head;

    class Node {
        String data;
        reverseLL.Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    public void addLast(String data) {
        //if there is no node
        reverseLL.Node newNode = new reverseLL.Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        //traverse the LL
        reverseLL.Node currNode = head;//no manipulation on head
        while (currNode.next != null) {
            currNode = currNode.next;//update
        }
        currNode.next = newNode;
    }

    public void printList() {
        if (head == null) {
            System.out.println("list is empty");
        }
        reverseLL.Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public void reverseIterate() {
        if (head == null || head.next == null) {
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            //update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    public Node reverseRecursion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        reverseLL list = new reverseLL();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.printList();
        list.reverseIterate();
        list.printList();
        list.head = list.reverseRecursion(list.head);
        list.printList();
    }
}
