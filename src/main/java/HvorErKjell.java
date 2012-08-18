import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;


public class HvorErKjell {

    public static void main(String[] args) throws IOException {
        new HvorErKjell().process(System.in, System.out);
    }

    void process(InputStream in, PrintStream out) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int count = Integer.parseInt(reader.readLine());
        for (int i=0; i<count; i++) {
            out.println(readSet(reader));
        }
    }

    private String readSet(BufferedReader reader) throws IOException {
        Map<String, String> sjefing = new HashMap<String, String>();
        int count = Integer.parseInt(reader.readLine());
        boolean kjellTilStede = false;
        for (int i=0; i<count; i++) {
            String line = reader.readLine();
            String master = line.split(" ")[0];
            String servant = line.split(" ")[1];
            sjefing.put(servant, master);
            if (master.equals("Kjell")) {
                kjellTilStede = true;
            }
        }

        String sjefen = sjefing.get("Kjell");
        if (sjefen == null) {
            return kjellTilStede ? "0" : "NOKJELL";
        }
        int sjefCount = 0;
        while (sjefen != null) {
            sjefCount++;
            sjefen = sjefing.get(sjefen);
        }
        return String.valueOf(sjefCount);
    }
}
