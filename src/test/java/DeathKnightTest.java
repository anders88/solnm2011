

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class DeathKnightTest {
	@Test
	public void shouldIndicatesNumberOfLinesWithoutCD() {
		int solution = new DeathKnight().solveIt("3\nDCOOO\nDODOCD\nCOD");
		assertThat(solution).isEqualTo(2);
	}
}
