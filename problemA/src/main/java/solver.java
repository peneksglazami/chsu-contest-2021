import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Решение задачи "A - Точное время".
 */
public class solver {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            solve(in, System.out);
        }
    }

    static void solve(Scanner in, PrintStream out) {
        String time = in.nextLine().trim();
        String revertedTime = time.substring(3, 4) + time.substring(2, 3) + time.substring(1, 2) + time.substring(0, 1);
        if (time.equals(revertedTime)) {
            out.print("YES");
        } else {
            Pattern pattern = Pattern.compile("(([0-1][0-9])|(2[0-3]))[0-5][0-9]");
            if (pattern.matcher(time).matches() && pattern.matcher(revertedTime).matches()) {
                out.print("NO");
            } else {
                out.print("YES");
            }
        }
    }
}