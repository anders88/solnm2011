

import static org.fest.assertions.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class IoTest {

    protected void assertOutput(Object... lines) {
        assertThat(getOutput()).contains(lines);
    }

    public static InputStream getInput(String... lines) {
        String file = "";
        for (String line : lines) {
            file += line + "\n";
        }
        return new ByteArrayInputStream(file.getBytes());
    }

    protected List<String> getOutput() {
        return Arrays.asList(new String(buffer.toByteArray()).split("\r?\n"));
    }

    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    public PrintStream output = new PrintStream(buffer);
}