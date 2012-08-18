import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;


public class KjellRegnerTest extends IoTest {

    @Test
    public void testName() throws IOException {
        new KjellRegner().process(getInput("2", "3", "100000", "200000", "300000", "2", "-30000", "20000"), output);
        assertThat(getOutput())
            .containsExactly("600000", "20000");
    }

}
