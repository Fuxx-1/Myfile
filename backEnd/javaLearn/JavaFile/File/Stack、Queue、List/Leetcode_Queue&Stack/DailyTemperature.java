import java.util.Scanner;
import java.util.Stack;

/**
 * @create: 2021-04-28 19:52
 **/
class StackForDT<T> {
    Node Head, Tail;
    int N;

    public StackForDT() {
        this.Head = new Node(null, null, null);
        this.Tail = Head;
        this.N = 0;
    }

    public void push(T item) {
        Node NewNode = new Node(item, Head, Head.next);
        if (N == 0) {
            this.Tail = NewNode;
        }
        if (Head.next != null) {
            this.Head.next.pre = NewNode;
        }
        this.Head.next = NewNode;
        N++;
    }

    public Node pop() {
        Node temp = Head.next;
        if (Head.next.next != null) {
            Head.next.next.pre = Head;
        }
        Head.next = Head.next.next;
        Tail.next = null;
        N--;
        return temp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public class Node {
        T item;
        Node next, pre;

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

        public T getItem() {
            return item;
        }
    }
}

public class DailyTemperature {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner Sc = new Scanner(System.in);
        int[] T = new int[100];
        for (int i = 0; i < 8; i++) {
            T[i] = Sc.nextInt();
        }
        int[] ret = new int[8];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        System.out.println(ret);
    }
}
