import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;


public class Oppgave6Test extends IoTest {

    @Test
    public void testName() throws NumberFormatException, IOException {
        Oppgave6.process(getInput("1", "4", "0944", "9033", "4303", "4330"), output);
        assertOutput("14");
    }

    @Test
    @Ignore
    public void large() throws IOException {
        Oppgave6.process(getInput("1", "20",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912",
                "12345678912345678912"), output);

    }

}
