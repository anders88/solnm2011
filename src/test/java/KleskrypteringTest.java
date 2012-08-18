import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;


public class KleskrypteringTest extends IoTest {

    @Test
    public void testName() throws Exception {
        new Kleskryptering().process(getInput("3", "programming, motherfucker", "steria open", "zed shaw"), output);
        assertThat(getOutput())
            .containsExactly("cebtenzzvat, zbgureshpxre", "fgrevn bcra", "mrq funj");

    }


}
