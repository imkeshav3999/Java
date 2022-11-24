public class queueArray {
    static class Queue {
        static int arr[];
        int size;
        static int rear = -1;

        Queue(int n) {
            arr = new int[n];
            this.size = n;
        }

        public boolean isEmpty() {
            return rear == -1;
        }
        //enqueue O(1)
        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("full queue");
                return;
            }
            rear++;
            arr[rear] = data;
        }
        //dequeue O(n)
        public int remove() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }
        //peek O(1)
        public int peek() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return arr[0];
        }
    }
    public static void main(String[] args) {
        Queue q=new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove(); 
        }
    }
}
