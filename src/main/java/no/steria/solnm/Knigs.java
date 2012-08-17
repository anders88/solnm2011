package no.steria.solnm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Knigs {

    public class Moose {

        public Integer startingYear;
        public int strength;

    }

    private int turnamentPool;
    private int yearsWithData;
    private Moose karlAlgav;

    private Map<Integer, List<Moose>> moosesByYear = new TreeMap<>();

    public void process(InputStream input, PrintStream out) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line = reader.readLine();
        this.turnamentPool = Integer.parseInt(line.split(" ")[0]);
        this.yearsWithData = Integer.parseInt(line.split(" ")[1]);

        this.karlAlgav = parseMoose(reader.readLine());
        addMoose(karlAlgav);
        for (int i=0; i<turnamentPool+yearsWithData-2; i++) {
            Moose moose = parseMoose(reader.readLine());
            addMoose(moose);
        }

        out.println(runTurnament());
    }

    private void addMoose(Moose moose) {
        if (!this.moosesByYear.containsKey(moose.startingYear)) {
            this.moosesByYear.put(moose.startingYear, new ArrayList<Moose>());
        }
        this.moosesByYear.get(moose.startingYear).add(moose);
    }

    private String runTurnament() {
        int firstYear = moosesByYear.keySet().iterator().next();

        List<Moose> activeMoose = new ArrayList<>();
        for (int year=0; year<yearsWithData; year++) {
            activeMoose.addAll(moosesByYear.get(firstYear+year));
            Moose winner = activeMoose.get(0);
            for (Moose moose : activeMoose) {
                if (moose.strength > winner.strength) winner = moose;
            }
            if (winner == karlAlgav) return String.valueOf(firstYear + year);
            activeMoose.remove(winner);
        }
        return "unknown";
    }

    private Moose parseMoose(String line) {
        Moose moose = new Moose();
        moose.startingYear = Integer.parseInt(line.split(" ")[0]);
        moose.strength = Integer.parseInt(line.split(" ")[1]);
        return moose;
    }

    public static void main(String[] args) throws IOException {
        new Knigs().process(System.in, System.out);
    }

}
