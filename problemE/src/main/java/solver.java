import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Решение задачи "E - Реновация".
 */
public class solver {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            solve(in, System.out);
        }
    }

    static void solve(Scanner in, PrintStream out) {
        int n = in.nextInt();
        int cnt = 0;
        for (int i = 2; i * (i - 1) / 2 < n; i++) {
            if ((n - i * (i - 1) / 2) % i == 0) {
                cnt++;
            }
        }
        out.print(cnt);
    }
}