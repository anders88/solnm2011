import org.junit.Ignore;
import org.junit.Test;


public class Oppgave1Test extends IoTest {

    @Test
    @Ignore
    public void testName() throws Exception {
        Oppgave1.process(getInput("2", "1#2", "453", "786", "123", "456", "87#"), output);
        assertOutput("3", "noway");
    }

}
