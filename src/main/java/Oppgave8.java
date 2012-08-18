import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Oppgave8 {


    public static void main(String[] args) throws NumberFormatException, IOException {
        new Oppgave8().process(System.in, System.out);
    }

    void process(InputStream in, PrintStream out) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int count = Integer.parseInt(reader.readLine());

        for (int i=0; i<count; i++) {
            out.println(fibonacci(Integer.parseInt(reader.readLine())) * 1000);
        }
    }

    private long fibonacci(int parseInt) {
        if (parseInt == 1) return 0;
        if (parseInt == 2) return 1;
        long f_n1 = 0;
        long f_n2 = 1;
        for (int i=2; i<parseInt; i++) {
            long tmp = f_n1 + f_n2;
            f_n1 = f_n2;
            f_n2 = tmp;
        }
        return f_n2;
    }
}
