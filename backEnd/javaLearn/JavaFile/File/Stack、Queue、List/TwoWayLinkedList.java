/**
 * @create: 2021-04-26 19:18
 **/
class LinkedListby2Way<T> {
    private Node Head, Tail;
    private int N;

    public LinkedListby2Way() {
        this.Head = new Node(null, null, null);
        Tail = Head;
        this.N = 0;
    }

    public void AddNodebyTail(T t) {//尾插法实现增加节点
        Node NewNode = new Node(t, Tail, null);
        Tail.next = NewNode;
        Tail = NewNode;
    }

    public void AddNodebyHead(T t) {//头插法实现增加节点
        Node NewNode = new Node(t, Head, Head.next);
        if (Head.next != null) {
            Head.next.pre = NewNode;
        }
        Head.next = NewNode;
        N++;
    }

    public void DeleteNode(T item) {
        Node n = Head;
        while (n.next != null) {
            if (n.next.item.equals(item)) {
                n.next.next.pre = n;
                n.next = n.next.next;
                break;
            }
            n = n.next;
        }
    }

    public void ChangeInfo(T old, T val) {
        Node n = Head;
        while (n.next != null) {
            if (n.next.item.equals(old)) {
                n.next.item = val;
                break;
            }
            n = n.next;
        }
    }

    public void IndexOf(int val) {
        Node n = Head.next;
        for (int i = 0; i < val - 1; i++) {
            n = n.next;
        }
        System.out.println(n.item);
    }


    public void PrintNode() {
        Node n = Head;
        while (n.next != null) {
            System.out.println(n.next.item);
            n = n.next;
        }
    }

    public void PrintNodebyTail() {
        Node n = Tail;
        System.out.println("------byTail--------");
        while (n.pre != null) {
            System.out.println(n.item);
            n = n.pre;
        }
    }

    private class Node {
        T item;
        Node next, pre;

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }
}

public class TwoWayLinkedList {
    public static void main(String[] args) {
        LinkedListby2Way<Object> list = new LinkedListby2Way<>();
        list.AddNodebyTail("12345sdf");
        list.AddNodebyTail(34534512);
        list.AddNodebyTail("jgh1234");
        list.PrintNode();
        list.PrintNodebyTail();
        System.out.println("------删除------");
        list.DeleteNode("12345sdf");
        list.PrintNode();
        list.PrintNodebyTail();
        System.out.println("-----更改后-----");
        list.ChangeInfo("jgh1234", 12345678);
        list.PrintNode();
        list.PrintNodebyTail();
        System.out.println("-----查询2------");
        list.IndexOf(2);
    }
}
