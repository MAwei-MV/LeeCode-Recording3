package Main;

public class TestSomething {
    int x = 0;

    public static void main(String args[]) {
        int parent[] = new int[4];
        int count = 0;
        TestSomething ts = new TestSomething();
        ts.x = 2;
        test(parent, count, ts);
        for (int i = 0; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
        System.out.println(count);
        System.out.println(ts.x);
    }

    private static int test(int parent1[], int count, TestSomething ts) {
        for (int i = 0; i < parent1.length; i++) {
            parent1[i] = i;
            count++;
            ts.x++;
        }
        return 1;
    }
}

