import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Решение задачи "C - Шах и мат".
 */
public class solver {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            solve(in, System.out);
        }
    }

    static void solve(Scanner in, PrintStream out) {
        int[][] w = new int[8][2];
        int[][] b = new int[8][2];
        for (int i = 0; i < 8; i++) {
            String str = in.nextLine();
            for (int j = 0; j < 8; j++) {
                if (str.charAt(j) == 'w') {
                    if (w[j][0] == 0) {
                        w[j][0] = i + 1;
                    } else {
                        w[j][1] = i + 1;
                    }
                } else if (str.charAt(j) == 'b') {
                    if (b[j][0] == 0) {
                        b[j][0] = i + 1;
                    } else {
                        b[j][1] = i + 1;
                    }
                }
            }
        }

        int steps = 0;
        for (int i = 0; i < 8; i++) {
            steps += (b[i][0] - w[i][1] - 1) + (b[i][1] - w[i][0] - 3);
        }
        
        out.print(steps);
    }
}