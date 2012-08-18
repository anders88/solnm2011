import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;


public class SteriaAtJavaZoneTest extends IoTest {

    @Test
    public void testName() throws IOException {
        InputStream input = getInput(
                "2", "4 6", "QWERTY", "ASDFGS", "SSQQRS", "POIUWW",
                "6 6", "WSSSWS", "ASDSAW", "RSSSSA", "POIUAW", "SOIASW", "SOISSW"
                );
        new SteriaAtJavaZone().process(input, output);
        assertThat(getOutput())
            .containsExactly("1", "2");
    }

}
