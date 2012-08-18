import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Oppgave6 {

    public static void main(String[] args) throws IOException {
        Oppgave6.process(System.in, System.out);
    }

    private int[][] distances;
    private int count;
    private int shortestLength = Integer.MAX_VALUE;

    public static void process(InputStream in, PrintStream out) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int count = Integer.parseInt(reader.readLine());
        for (int i=0; i<count; i++) {
            out.println(new Oppgave6().readSet(reader));
        }
    }

    private int readSet(BufferedReader reader) throws IOException {
        readBoard(reader);

        for (int startLocation=0; startLocation<count; startLocation++) {
            boolean[] visited = new boolean[count];
            visited[startLocation] = true;
            search(0, 0, visited, startLocation, startLocation);
        }

        return shortestLength;
    }

    private void readBoard(BufferedReader reader) throws IOException {
        count = Integer.parseInt(reader.readLine());
        distances = new int[count][count];
        for (int i=0; i<count; i++) {
            char[] line = reader.readLine().toCharArray();
            for (int j = 0; j < line.length; j++) {
                distances[i][j] = Integer.parseInt(String.valueOf(line[j]));
            }
        }
    }

    private void search(int pathLength, int currentLength, boolean[] visited, int previousLocation, int startLocation) {
        if (currentLength >= shortestLength) return;
        if (pathLength == count-1) {
            shortestLength = Math.min(currentLength + distances[previousLocation][startLocation], shortestLength);
            return;
        }

        for (int location=0; location<count; location++) {
            if (visited[location]) continue;
            visited[location] = true;
            search(pathLength + 1,
                currentLength + distances[previousLocation][location],
                visited, location, startLocation);
            visited[location] = false;
        }
    }

}
