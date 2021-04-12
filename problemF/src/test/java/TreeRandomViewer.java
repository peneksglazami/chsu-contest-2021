import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class TreeRandomViewer {

    private static boolean[][] b;
    private static boolean[] v;
    private static int n;
    private static final Random rand = new Random();

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File("problemF/src/test/resources/tree01.txt"))) {
            n = in.nextInt();
            b = new boolean[n][n];
            for (int i = 1; i < n; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                b[x - 1][y - 1] = true;
            }
        }

        v = new boolean[n];
        walk(0, System.out);

        System.out.println();
        v = new boolean[n];
        walk(0, System.out);
    }

    private static void walk(int node, PrintStream out) {
        v[node] = true;
        boolean nadoelo;
        do {
            nadoelo = true;
            for (int i = 0; i < n; i++) {
                if (b[node][i] && !v[i]) {
                    nadoelo = false;
                    if (rand.nextBoolean()) {
                        out.print("0");
                        walk(i, out);
                        out.print("1");
                    }
                }
            }
        } while (!nadoelo);
    }
}
