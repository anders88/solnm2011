package no.steria.solnm;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class ElevatorTest {
	@Test
	public void shouldIndicateMoves() throws Exception {
		String solution = new Elevator().solve(10,1,10,2,1);
		assertThat(solution).isEqualTo("6");
	}
	
	@Test
	public void shouldIndicateImpossible() throws Exception {
		String solution = new Elevator().solve(100,2,1,1,0);
		assertThat(solution).isEqualTo("use the stairs");
		
	}
}
