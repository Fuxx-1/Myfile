import java.util.Scanner;

/**
 * @create: 2021-04-28 16:54
 **/
class StackForRPN<T> {
    Node Head, Tail;
    int N;

    public StackForRPN() {
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

public class ReversePolishNotation {
    public static void main(String[] args) {
        StackForRPN<Integer> St1 = new StackForRPN<>();
//        StackForRPN<Object> St2 = new StackForRPN<>();
        Scanner Sc = new Scanner(System.in);
        String Sen = Sc.nextLine();
        String NewSen = Sen.replaceAll(" ", "");
        char[] val = NewSen.toCharArray();
        System.out.println(val);
        for (int i = 0; i < val.length; i++) {
            String temp = String.valueOf(val[i]);
            if (isNumber(temp)) {
                St1.push(Integer.parseInt(temp));
            } else {
                int num2 = St1.pop().getItem();
                int num1 = St1.pop().getItem();
                switch (temp) {
                    case "+":
                        St1.push(num1 + num2);
                        break;
                    case "-":
                        St1.push(num1 - num2);
                        break;
                    case "*":
                        St1.push(num1 * num2);
                        break;
                    case "/":
                        St1.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        System.out.println(St1.pop().getItem());
    }

    public static boolean isNumber(String a) {
        for (int i = 0; i < 10; i++) {
            if (a.equals(String.valueOf(i))) {
                return true;
            }
        }
        return false;
    }
}
