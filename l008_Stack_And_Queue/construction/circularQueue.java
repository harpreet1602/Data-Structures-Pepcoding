import java.util.Scanner;

public class circularQueue {
    public static Scanner scn = new Scanner(System.in);

    public static class MyCircularQueue {
        private int[] arr;
        private int front = 0, rear = -1, size = 0;

        public MyCircularQueue(int k) {
            arr = new int[k];
        }

        public boolean enQueue(int value) {
            if (!isFull()) {
                rear = (rear + 1) % arr.length;
                arr[rear] = value;
                size++;
                return true;
            } else
                return false;
        }

        public int deQueue() {
            if (!isEmpty()) {
                int ele = arr[front];
                front = (front + 1) % arr.length;
                size--;
                return ele;
            } else {
                return -1;
            }
        }

        public int Front() {
            return isEmpty() ? -1 : arr[front];
        }

        public int Rear() {
            return isEmpty() ? -1 : arr[rear];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == arr.length;
        }

        public void display() {
            int len = size;
            int idx = front;
            while (len-- > 0) {
                System.out.print(arr[idx] + " ");
                idx = (idx + 1) % arr.length;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter the size of the circular queue: ");
        MyCircularQueue que = new MyCircularQueue(scn.nextInt());
        int ch = 8;
        do {
            System.out.println();
            System.out.println("Menu");
            System.out.println("1.enQueue");
            System.out.println("2.deQueue");
            System.out.println("3.front");
            System.out.println("4.rear");
            System.out.println("5.isEmpty");
            System.out.println("6.isFull");
            System.out.println("7.display");
            System.out.println("8.Exit");
            ch = scn.nextInt();
            switch (ch) {
            case 1:
                System.out.print("Enter the element: ");
                System.out.println(que.enQueue(scn.nextInt()));
                break;
            case 2:
                System.out.println(que.deQueue() + " removed");
                break;
            case 3:
                System.out.println(que.Front());
                break;
            case 4:
                System.out.println(que.Rear());
                break;
            case 5:
                System.out.println(que.isEmpty());
                break;
            case 6:
                System.out.println(que.isFull());
                break;
            case 7:
                System.out.print("List is: ");
                que.display();
                break;
            default:
                System.exit(0);
            }
        } while (true);
    }
}