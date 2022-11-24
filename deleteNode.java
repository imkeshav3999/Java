public class deleteNode {
    Node head;

    class Node {
        int data;
        deleteNode.Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void addLast(int data) {
        deleteNode.Node newNode = new deleteNode.Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        deleteNode.Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
        }
        deleteNode.Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    // Nth NODE FROM LAST + DELETE Nth NODE
    // distance from start = (size-n+1)
    // dfs of prev node = size-n
    public Node remove(int n) {
        if (head.next == null) {
            return null;
        }
        int size = 0;
        deleteNode.Node curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        // deleting the head
        if (n == size) {
            return head.next;
        }
        int indexToSearch = size - n;
        deleteNode.Node prev = head;
        int i = 1;
        while (i < indexToSearch) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }

    public static void main(String[] args) {
        deleteNode list = new deleteNode();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.printList();
        list.remove(4);
        list.printList();
    }
}
