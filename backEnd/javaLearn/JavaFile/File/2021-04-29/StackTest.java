/**
 * @create: 2021-04-29 19:06
 **/
class TestForStack {
    private Node Head, Tail;
    private int N;
    private int Max;

    public TestForStack() {
        Head = new Node(0, null, null);
        Tail = Head;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int getMax() {
        return Max;
    }


    public int pop() {
        Node Temp = Head.next;
        if (Temp.next != null) {
            Temp.next.pre = Temp.pre;
        }
        Temp.pre.next = Temp.next;
        N--;
        if (N == 0) {
            Tail = null;
        }
        if (Temp.item == Max) {
            Node pMove = Head.next;
            for (int i = 0; i < N; i++) {
                if (pMove.item > Max || i == 0) {
                    Max = pMove.item;
                }
                pMove = pMove.next;
            }
        }
        return Temp.item;
    }

    public void push(int t) {
        Node NewNode = new Node(t, Head, Head.next);
        if (t > Max || N == 0) {
            Max = t;
        }
        if (N == 0) {
            Tail = NewNode;
        }
        if (Head.next != null) {
            Head.next.pre = NewNode;
        }
        Head.next = NewNode;
        N++;
    }

    public int peek() {
        return Head.next.item;
    }

    public class Node {
        private int item;
        private Node pre, next;

        public Node(int t, Node pre, Node next) {
            this.item = t;
            this.pre = pre;
            this.next = next;
        }
    }
}

public class StackTest {
    public static void main(String[] args) {
        TestForStack St = new TestForStack();
        St.push(3);
        St.push(7);
        St.push(9);
        St.push(2);
        System.out.println(St.peek());
        St.pop();
        St.pop();
        System.out.println(St.peek());
        System.out.println(St.isEmpty());
        System.out.println(St.getMax());
    }
}
