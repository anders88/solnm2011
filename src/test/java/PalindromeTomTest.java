import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;


public class PalindromeTomTest extends IoTest {

    @Test
    public void testName() throws IOException {
        new PalinedromeTom().process(getInput("2", "41587514", "97144179"), output);
        assertThat(getOutput())
            .contains("3", "TACOCAT");
    }

    PalinedromeTom palinedromeTom = new PalinedromeTom();
    @Test
    public void testName2() throws IOException {
        palinedromeTom.process(getInput("2", "12345678", "97144179"), output);
        assertThat(getOutput())
            .contains("0", "TACOCAT");
    }

    @Test
    public void testName3() {
        assertThat(palinedromeTom.palindromeCount("87244179".toCharArray())).isEqualTo("2");
    }

}
