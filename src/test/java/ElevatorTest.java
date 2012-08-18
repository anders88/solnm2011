

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class ElevatorTest {
	@Test
	public void shouldIndicateMoves() {
		String solution = new Elevator().solve(10,1,10,2,1);
		assertThat(solution).isEqualTo("6");
	}

	@Test
	public void shouldIndicateImpossible() {
		String solution = new Elevator().solve(100,2,1,1,0);
		assertThat(solution).isEqualTo("use the stairs");

	}
}
