public class palindromeLL {

    class Node {
        int data;
        palindromeLL.Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    public void addLast(int data) {
        palindromeLL.Node newNode = new palindromeLL.Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        palindromeLL.Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
        }
        palindromeLL.Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public Node reverse(Node head) {
        palindromeLL.Node prev = null;
        palindromeLL.Node curr = head;
        while (curr != null) {
            palindromeLL.Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node findMiddle(Node head) {
        palindromeLL.Node hare = head;
        palindromeLL.Node turtle = head;
        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        palindromeLL.Node middle = findMiddle(head);// 1st half ka end
        palindromeLL.Node firstHalfStart = head;
        palindromeLL.Node secondHalfStart = reverse(middle.next);

        while (secondHalfStart != null) {
            if (firstHalfStart.data != secondHalfStart.data) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }

    // public boolean hasCycle(Node head) {
    //     if (head == null) {
    //         return false;
    //     }
    //     Node hare = head;
    //     Node turtle = head;
    //     while (hare != null && hare.next != null) {
    //         hare = hare.next.next;
    //         turtle = turtle.next;
    //         if (hare == turtle) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    public static void main(String[] args) {
        palindromeLL list = new palindromeLL();
        // int num[] = { 1, 2, 2, 1 };
        // for (int i = 0; i < num.length; i++) {
        // list.addLast(num[i]);
        // }
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);
        list.printList();
        boolean v = list.isPalindrome(list.head);
        System.out.println(v);
    }
}
