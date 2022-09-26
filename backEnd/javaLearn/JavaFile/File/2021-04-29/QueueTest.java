/**
 * @create: 2021-04-29 19:06
 **/

import java.util.Scanner;

/**
 * @create: 2021-04-29 19:06
 **/
class TestForQueue<T> {
    private Node Head, Tail;
    private int N;

    public TestForQueue() {
        Head = new Node(null, null, null);
        Tail = Head;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public T pop() {
        Node Temp = Tail;
        Temp.pre.next = null;
        N--;
        Tail = Temp.pre;
        return Temp.item;
    }

    public void push(T t) {
        Node NewNode = new Node(t, Head, Head.next);
        if (N == 0) {
            Tail = NewNode;
        }
        if (Head.next != null) {
            Head.next.pre = NewNode;
        }
        Head.next = NewNode;
        N++;
    }

    public T peek() {
        return Tail.item;
    }

    public class Node {
        private T item;
        private Node pre, next;

        public Node(T t, Node pre, Node next) {
            this.item = t;
            this.pre = pre;
            this.next = next;
        }
    }
}

public class QueueTest {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int a = Sc.nextInt();
        int b = Sc.nextInt();
        String[] val = new String[a];
        for (int i = 0; i < a; i++) {
            val[i] = Sc.next();
        }
        char[][] ch = new char[a][b];
        for (int i = 0; i < a; i++) {
            ch[i] = val[i].toCharArray();
        }
        boolean[][] vis = new boolean[ch.length][ch[0].length];
        TestForQueue<int[]> Qu = new TestForQueue<>();
        BFS(Qu, vis, ch, 0, 0, 0);
    }

    public static void BFS(TestForQueue<int[]> Qu, boolean[][] vis, char a[][], int Step, int i, int j) {
        if (a == null || a.length == 0) {
            System.out.println(-1);
        }
        if (a[i][j] == '-' && !vis[i][j]) {
            Qu.push(new int[]{Step + 1, i, j});
            vis[i][j] = true;
        } else {
            return;
        }
        if (!Qu.isEmpty()) {
            int[] q;
            q = Qu.pop();
            if (q[1] == a.length - 1 && q[2] == a[0].length - 1 && a[q[1]][q[2]] == '-') {
                System.out.println(q[0]);
                return;
            } else {
                if (a[q[1]][q[2]] == '-') {
                    if (i + 1 < a.length && j < a[0].length) {
                        BFS(Qu, vis, a, Step + 1, i + 1, j);
                    }
                    if (i - 1 < a.length && j < a[0].length && i - 1 >= 0) {
                        BFS(Qu, vis, a, Step + 1, i - 1, j);
                    }
                    if (i < a.length && j + 1 < a[0].length) {
                        BFS(Qu, vis, a, Step + 1, i, j + 1);
                    }
                    if (i < a.length && j - 1 < a[0].length && j - 1 >= 0) {
                        BFS(Qu, vis, a, Step + 1, i, j - 1);
                    }
                }
                else{
                    return;
                }
            }
        }
    }
}
