import java.io.IOException;

import org.junit.Test;


public class Oppgave9Test extends IoTest {

    @Test
    public void testName() throws NumberFormatException, IOException {
        Oppgave9.process(getInput("2", "14 14 22 35 35", "34 22 23 37 25"), output);
        assertOutput("2", "1");
    }

    @Test
    public void testName2() throws NumberFormatException, IOException {
        Oppgave9.process(getInput("1", "34 22 23 37 25"), output);
        assertOutput("1");
    }

}
