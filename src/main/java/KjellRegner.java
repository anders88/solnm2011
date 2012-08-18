import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class KjellRegner {

    public static void main(String[] args) throws IOException {
        new KjellRegner().process(System.in, System.out);
    }

    void process(InputStream in, PrintStream out) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int count = Integer.parseInt(reader.readLine());

        for (int i=0; i<count; i++) {
            readSet(reader, out);
        }
    }

    private void readSet(BufferedReader reader, PrintStream out) throws IOException {
        int count = Integer.parseInt(reader.readLine());
        long sum = 0;
        for (int i=0; i<count; i++) {
            long row = Long.parseLong(reader.readLine());
            if (row > 0) {
                sum += row;
            }
        }
        out.println(sum);
    }

}
