import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Kleskryptering {

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Kleskryptering().process(System.in, System.out);
    }

    void process(InputStream in, PrintStream out) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int count = Integer.parseInt(reader.readLine());

        for (int i=0; i<count; i++) {
            out.println(rot13(reader.readLine()));
        }
    }

    private char[] rot13(String readLine) {
        char[] output = new char[readLine.length()];
        for (int i = 0; i < output.length; i++) {
            char c = readLine.charAt(i);
            if (Character.isLowerCase(c)) {
                output[i] = (char) ('a' + ((readLine.charAt(i) - 'a' + 13) % 26));
            } else if (Character.isUpperCase(c)) {
                output[i] = (char) ('A' + ((readLine.charAt(i) - 'A' + 13) % 26));
            } else {
                output[i] = c;
            }
        }
        return output;
    }


}
