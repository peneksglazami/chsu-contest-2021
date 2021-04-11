import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Решение задачи "D - Путешествия".
 */
public class solver {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            solve(in, System.out);
        }
    }

    static void solve(Scanner in, PrintStream out) {
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        String[] king = new String[n];
        String[] queen = new String[m];
        for (int i = 0; i < n; i++) {
            king[i] = in.nextLine();
        }
        for (int i = 0; i < m; i++) {
            queen[i] = in.nextLine();
        }

        int[][] t = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (king[i - 1].equals(queen[j - 1])) {
                    t[i][j] = Math.max(t[i - 1][j - 1] + 1, Math.max(t[i - 1][j], t[i][j - 1]));
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        out.print(t[n][m]);
    }
}