

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import org.junit.Test;

public class LsTest extends IoTest {

    @Test
    public void sampleInput1() throws IOException {
        Ls ls = new Ls();
        ls.process(getInput("*.*", "4", "main.c", "a.out", "readme", "yacc"), output);
        assertThat(getOutput())
            .containsExactly("main.c", "a.out");
    }


    @Test
    public void sampleInput2() throws IOException {
        Ls ls = new Ls();
        ls.process(getInput("*a*a*a", "4", "aaa", "aaaaa", "aaaaax", "abababa"), output);
        assertThat(getOutput())
            .containsExactly("aaa", "aaaaa", "abababa");
    }

    @Test
    public void toRegexp() {
        assertThat(Ls.toRegexp("*.*")).isEqualTo(".*\\..*");
    }

    @Test
    public void regexpMatch() {
        assertThat("a.out".matches(".*\\..*")).isTrue();
    }

}
