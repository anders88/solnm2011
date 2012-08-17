package no.steria.solnm;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class KnigsTest extends IoTest {

    @Test
    public void sampleInput1() throws IOException {
        Knigs knigs = new Knigs();
        InputStream input = getInput("2 4", "2013 2", "2011 1", "2011 3", "2014 4", "2012 6");
        knigs.process(input, output);
        assertThat(getOutput())
            .containsExactly("2013");
    }

    @Test
    public void sampleInput2() throws IOException {
        Knigs knigs = new Knigs();
        InputStream input = getInput("2 4", "2011 1", "2013 2", "2012 4", "2011 5", "2014 3");
        knigs.process(input, output);
        assertThat(getOutput()).containsExactly("unknown");
    }

}
