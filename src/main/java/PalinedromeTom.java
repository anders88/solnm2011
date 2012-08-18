import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class PalinedromeTom {

    public static void main(String[] args) throws IOException {
        new PalinedromeTom().process(System.in, System.out);
    }

    void process(InputStream in, PrintStream out) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int count = Integer.parseInt(reader.readLine());

        for (int i=0; i<count; i++) {
            out.println(palindromeCount(reader.readLine().toCharArray()));
        }
    }

    String palindromeCount(char[] line) {
        int result = 0;
        for (int teller = 0; teller<line.length/2; teller++ ){
            if (line[teller] == line[line.length-teller-1]) {
                result++;
            }
        }
        if (result < line.length/2) {
            return String.valueOf(result);
        }
        return "TACOCAT";
    }

}
