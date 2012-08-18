import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class SteriaAtJavaZone {

    public static void main(String[] args) throws IOException {
        SteriaAtJavaZone.process(System.in, System.out);
    }

    static void process(InputStream in, PrintStream out) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int count = Integer.parseInt(reader.readLine());
        for (int i=0; i<count; i++) {
            new SteriaAtJavaZone().readExerciseSet(reader, out);
        }
    }

    private boolean[][] visited;
    private char[][] cells;
    private int rows;
    private int cols;

    private void readExerciseSet(BufferedReader reader, PrintStream out) throws IOException {
        String specLine = reader.readLine();
        rows = Integer.parseInt(specLine.split(" ")[0]);
        cols = Integer.parseInt(specLine.split(" ")[1]);

        this.cells = new char[rows][];
        this.visited = new boolean[rows][cols];
        for (int i=0; i<rows; i++ ) {
            cells[i] = reader.readLine().toCharArray();
        }

        int groups = 0;
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if ( groupSizeFrom(r, c) >= 3) {
                    groups++;
                }
            }
        }
        out.println(groups);
    }

    private boolean isSterian(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols && cells[r][c] == 'S';
    }

    private int groupSizeFrom(int r, int c) {
        if (isSterian(r, c) && !visited[r][c]) {
            visited[r][c] = true;
            return 1 + groupSizeFrom(r+1, c) + groupSizeFrom(r, c + 1) + groupSizeFrom(r - 1, c) + groupSizeFrom(r, c - 1);
        } else {
            return 0;
        }
    }

}
