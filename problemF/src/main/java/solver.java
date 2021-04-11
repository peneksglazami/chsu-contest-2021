import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Решение задачи "F - Дерево".
 */
public class solver {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            solve(in, System.out);
        }
    }

    static void solve(Scanner in, PrintStream out) {
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        if (normalize(s1).equals(normalize(s2))) {
            out.print("YES");
        } else {
            out.print("NO");
        }
    }

    private static String normalize(String s) {
        if (s.isEmpty()) {
            return "";
        }
        List<String> subtrees = new ArrayList<>();
        int cnt = 0;
        int subtreeStartIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt--;
            } else {
                cnt++;
            }
            if (cnt == 0) {
                subtrees.add('0' + normalize(s.substring(subtreeStartIndex + 1, i)) + '1');
                subtreeStartIndex = i + 1;
            }
        }
        Collections.sort(subtrees);
        return String.join("", subtrees);
    }
}