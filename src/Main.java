import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        minimumBribes(Arrays.asList(2, 1, 5, 3, 4));
    }

    public static void minimumBribes(List<Integer> q) {
        int count = q.size();
        var bribes = 0;
        var tooCha = false;
        for (int i = q.size() - 1; i >= 0; i--) {
            int expected = i + 1;
            if (q.get(i) == expected) {
                continue;
            } else if (i - 1 >= 0 && q.get(i - 1) == expected) {
                bribes++;
                // reorder array
                q.set(i - 1, q.get(i));
                q.set(i, expected);
                continue;
            } else if (i - 2 >= 0 && q.get(i - 2) == expected) {
                bribes += 2;
                // reorder array
                q.set(i - 2, q.get(i - 1));
                q.set(i - 1, q.get(i));
                q.set(i, expected);
                continue;
            }

            // bribed more than twice - break loop
            tooCha = true;
            break;
        }
        if (tooCha) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribes);
        }
    }
}