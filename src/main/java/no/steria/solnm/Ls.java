package no.steria.solnm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Ls {

    private List<String> files = new ArrayList<>();

    private String regExpPattern;

    public void process(InputStream in, PrintStream output) throws IOException {
        readInput(in);

        for (String file : files) {
            if (matchesPattern(file)) {
                output.println(file);
            }
        }
    }

    private boolean matchesPattern(String file) {
        return file.matches(regExpPattern);
    }

    private void readInput(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        setPattern(reader.readLine());
        int count = Integer.parseInt(reader.readLine().trim());
        for (int i=0; i<count; i++ ) {
            this.files.add(reader.readLine());
        }
    }

    public void setPattern(String pattern) {
        this.regExpPattern = toRegexp(pattern);
    }

    static String toRegexp(String pattern) {
        return pattern
                .replaceAll("\\.", "\\\\.")
                .replaceAll("\\*", ".*");
    }

    public static void main(String[] args) throws IOException {
        new Ls().process(System.in, System.out);
    }
}
