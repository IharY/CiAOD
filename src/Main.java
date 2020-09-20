public class Main {
    public static void main(String[] args) {
        List p = new List();
        List.addEl(4, 7, p.root);
        List.addEl(1, 3, p.root);
        List.addEl(2, 9, p.root);
        List q = new List();

        List.addEl(1, 6, q.root);
        List.addEl(3, 2, q.root);
        List.addEl(2, 10, q.root);

        System.out.println("Список №1");
        List.showList(p.root.next);
        System.out.println();

        System.out.println("Список №2");
        List.showList(q.root.next);

        System.out.println();
        System.out.print("Списки ");
        List.equality(p, q);
        System.out.println();
        System.out.print("При x равном 2: ");
        List.meaning(p, 2);
        List a = List.add(p, q);
        System.out.println();
        System.out.println("Сумма списков: ");
        List.showList(a.root.next);
    }
}
