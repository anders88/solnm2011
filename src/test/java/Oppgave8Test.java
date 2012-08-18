import java.io.IOException;

import org.junit.Test;


public class Oppgave8Test extends IoTest {

    @Test
    public void testName() throws NumberFormatException, IOException {
        new Oppgave8().process(getInput("3", "1", "5", "10"), output);
        assertOutput("0", "3000", "34000");
    }


    @Test
    public void testName2() throws NumberFormatException, IOException {
        new Oppgave8().process(getInput("1", "60"), output);
    }

}
