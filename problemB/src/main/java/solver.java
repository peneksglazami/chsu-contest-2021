import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Решение задачи "B - Неправильно сели".
 */
public class solver {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            solve(in, System.out);
        }
    }

    static void solve(Scanner in, PrintStream out) {
        int n = in.nextInt();
        int a = n / 2;
        int b = n - a;
        out.print((a * (a - 1) / 2) + (b * (b - 1) / 2));
    }
}