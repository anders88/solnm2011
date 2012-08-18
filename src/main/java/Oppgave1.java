import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Oppgave1 {

    public static void main(String[] args) throws IOException {
        Oppgave1.process(System.in, System.out);
    }

    public static void process(InputStream in, PrintStream out) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int count = Integer.parseInt(reader.readLine());
        for (int i=0; i<count; i++) {
            out.println(new Oppgave1().solvePuzzleSet(reader));
        }
    }

    private String solvePuzzleSet(BufferedReader in) throws IOException {
        Integer[][] cells = new Integer[3][3];
        for (int row=0; row<3; row++) {
            char[] cs = in.readLine().toCharArray();

            for (int col=0; col<3; col++) {
                if (cs[col] != '#') {
                    cells[row][col] = Integer.parseInt(String.valueOf(cs[col]));
                }
            }


        }
        return null;
    }

}
