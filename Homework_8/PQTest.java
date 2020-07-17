import utility.PriorityQueue;

public class PQTest {
    public static void main(String[] args) {
        try {
            PriorityQueue<String, Integer> p1 = new PriorityQueue<>();
            p1.add("coffee", 10);
            p1.add("milk", 8);
            p1.add("tea", 11);
            p1.add("cake", 22);
            p1.add("sake", 3);

            assert(p1.size() == 5);
            assert(p1.peek() == "cake");
            p1.remove();
            assert(p1.peek() == "tea");
            p1.add("matcha", 11);
            String s = p1.remove();
            assert(s.equals("tea") || s.equals("matcha") == true);

            p1.reset();
            assert(p1.size() == 0);
            assert(p1.remove() == null);
            PriorityQueue<String, Integer> p2 = new PriorityQueue<>();

            for(int i = 0; i < 10; i++) {
                int a = (int) 'a' + i;
                int b = (int) 'a' + 9 - i;
                Character x = (char) a;
                Character y = (char) b;
                p1.add(x.toString(), i);
                p1.add(x.toString(), i);
                p2.add(y.toString(), 9 - i);
                p2.add(y.toString(), 9 - i);
            }

            assert(p1.size() == 20);
            assert(p2.size() == 20);
            assert(p1.equals(p2) && p2.equals(p1));

            p1.remove();
            assert(!(p1.equals(p2) || p2.equals(p1)));

            // Here the type of the priority values is String
            PriorityQueue<Integer, String> p3 = new PriorityQueue<>();
            p3.add(1, "a");
            p3.add(2, "A");
            assert(p3.peek().equals(1));
        } catch(AssertionError e) {
            System.err.println("Does not pass.");
            System.exit(1);
        }
        System.out.println("Passes.");
    }
}