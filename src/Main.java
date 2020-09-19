
class Main {
    static class Node {
        Node next;
        int k;
        int n;

        Node(int n, int k) {
            this.k = k;
            this.n = n;
        }

        public Node() {
        }
    }

    static class List {
        Node root = new Node();

        static void addEl(int n, int k, Node root) {
            if (root.next == null) {
                root.next = new Node(n, k);
                return;
            } else if (root.next.n < n) {
                Node node = new Node(n, k);
                node.next = root.next;
                root.next = node;
                return;
            }
            addEl(n, k, root.next);
        }

        static void showList(Node root) {
            if (root.next == null) {
                System.out.println(root.k + " " + root.n);
                return;
            } else {
                System.out.println(root.k + " " + root.n);
            }
            showList(root.next);
        }

        static void meaning(List p, int x) {
            int sum = 0;
            System.out.println(calc(p.root, sum, x));
        }

        static private int calc(Node root, int sum, int x) {
            sum += root.k * Math.pow(x, root.n);
            if (root.next == null) {
                return sum;
            }
            return calc(root.next, sum, x);
        }

        static void equality(List p, List q) {
            if (check(p.root, q.root, true)) {
                System.out.println("Равны");
            } else {
                System.out.println("Не равны");
            }
        }

        static List add(List p, List q) {
            List temp = new List();
            sum(p.root.next, q.root.next, temp.root);
            List temp2 = new List();
            sort(temp.root.next, temp2.root);
            sum2(temp2.root.next);
            return temp2;
        }

        static private void sum(Node root, Node root1, Node root2) {
            if (root != null) {
                root2.next = root;
                sum(root.next, root1, root2.next);
            } else if (root1 != null) {
                root2.next = root1;
                sum(null, root1.next, root2.next);
            }
        }

        static private void sort(Node root, Node root1) {
            if (root != null) {
                addEl(root.n, root.k, root1);
                sort(root.next, root1);
            }
        }

        static private void sum2(Node root) {
            if (root.n == root.next.n) {
                root.k += root.next.k;
                root.next = root.next.next;
            }
            if (root.next != null) {
                sum2(root.next);
            }
        }

        static private boolean check(Node root, Node root1, boolean isTrue) {
            if (root.n != root1.n || root.k != root1.k) {
                isTrue = false;
            } else if (root.next != null) {
                isTrue = check(root.next, root1.next, isTrue);
            } else {
                isTrue = true;
            }
            return isTrue;
        }

    }

    public static void main(String[] args) {
        List p = new List();
        List.addEl(1, 10, p.root);
        List.addEl(3, 10, p.root);
        List.addEl(2, 10, p.root);
        List q = new List();
        List.addEl(1, 10, q.root);
        List.addEl(3, 10, q.root);
        List.addEl(2, 10, q.root);
        List.equality(p, q);
        List.showList(p.root.next);
        System.out.println();
        List.showList(q.root.next);
        List.meaning(p, 2);
        List a = List.add(p, q);
        List.showList(a.root.next);
    }
}
