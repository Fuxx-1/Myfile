/**
 * @create: 2021-04-26 13:46
 **/
//栈
class StackTest<T> {
    private Node Head, Tail;
    private int N;

    public StackTest() {
        this.Head = new Node(null, null, null);
        Tail = Head;
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void Add(T item) {
        Node NewNode = new Node(item, Head, Head.next);
        if (N == 0) {
            Tail = NewNode;
        }
        if (Head.next != null) {
            Head.next.pre = NewNode;
        }
        Head.next = NewNode;
        N++;
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

    public Node Pop() {
        Node val;
        val = Head.next;
        if (Head.next.next != null){
            Head.next.next.pre = Head;
        }
        Head.next = Head.next.next;
        N--;
        return val;
    }

}

public class Stack {
    public static void main(String[] args) {
        StackTest<Object> St = new StackTest<>();
        St.Add("jklasdfjklsdf");
        St.Add(234112344);
        System.out.println(St.Pop().getItem());
        System.out.println(St.Pop().getItem());
        System.out.println(St.isEmpty());
    }
}
