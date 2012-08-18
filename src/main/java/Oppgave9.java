import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Oppgave9 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Oppgave9.process(System.in, System.out);
    }

    private int[] elevatorPositions;
    private int minSteps = 100;

    public static void process(InputStream in, PrintStream output) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int count = Integer.parseInt(reader.readLine());

        for (int i=0; i<count; i++) {
            output.println(new Oppgave9().runIt(reader));
        }
    }

    private int runIt(BufferedReader reader) throws IOException {
        String[] line = reader.readLine().split(" ");
        this.elevatorPositions = new int[line.length];
        for (int j = 0; j < elevatorPositions.length; j++) {
            elevatorPositions[j] = Integer.parseInt(line[j]);
        }
        runFrom(0);
        return minSteps;
    }

    private void runFrom(int currSteps) {
        if (elevatorsAreOutsideBuilding()) {
            return;
        }
        if (currSteps >= minSteps) {
            return;
        }
        if (allAreCorrect(elevatorPositions)) {
            this.minSteps = Math.min(minSteps, currSteps);
            return;
        }
        int[][] permutations = getPermutations();
        for (int[] js : permutations) {
            int heisA = js[0];
            int heisB = js[1];
            if (correctPosition(elevatorPositions[heisA]) || correctPosition(elevatorPositions[heisB])) {
                continue;
            }

            elevatorPositions[heisA] += 8;
            elevatorPositions[heisB] += 8;
            runFrom(currSteps + 1);
            elevatorPositions[heisA] -= 8;
            elevatorPositions[heisB] -= 8;

            elevatorPositions[heisA] -= 13;
            elevatorPositions[heisB] -= 13;
            runFrom(currSteps+1);
            elevatorPositions[heisA] += 13;
            elevatorPositions[heisB] += 13;
        }
    }

    private boolean elevatorsAreOutsideBuilding() {
        for (int etasje : elevatorPositions) {
            if (etasje < 1 || etasje > 49) return true;
        }
        return false;
    }

    private int[][] getPermutations() {
        return new int[][] {
            {0,1}, {0,2}, {0,3}, {0,4},
            {1,2}, {1,3}, {1,4},
            {2,3}, {2,4},
            {3,4},
        };
    }

    private boolean allAreCorrect(int[] elevatorPositions) {
        for (int i : elevatorPositions) {
            if (!correctPosition(i)) return false;
        }
        return true;
    }

    private boolean correctPosition(int etasje) {
        return etasje >= 21 && etasje <= 25;
    }

}
