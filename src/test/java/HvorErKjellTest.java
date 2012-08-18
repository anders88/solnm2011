import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;


public class HvorErKjellTest extends IoTest {

    @Test
    public void testName() throws IOException {
        new HvorErKjell().process(getInput("2", "3", "Tore Kjell", "Gudrun Tore", "Nils Gudrun", "4", "Bjarte Trude", "Trude Åge", "Trude Tom", "Torbjørn Bjarte"), output);
        assertThat(getOutput())
            .containsExactly("3", "NOKJELL");
    }

    @Test
    public void testName2() throws IOException {
        new HvorErKjell().process(getInput("1", "2", "Kjell Tore", "Tore Gudrun"), output);
        assertThat(getOutput())
            .containsExactly("0");
    }

}
