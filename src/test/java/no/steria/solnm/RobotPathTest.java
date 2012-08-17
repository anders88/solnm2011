package no.steria.solnm;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class RobotPathTest {
	@Test
	public void shouldReturnOneIfOnePath() {
		RobotPath robotPath = new RobotPath("4\n....\n###.\n###.\n###.");
		String solution = robotPath.solveIt();
		assertThat(solution).isEqualTo("1");
	}

	@Test
	public void shouldReturnNumberOfSolution() {
		RobotPath robotPath = new RobotPath("5\n.....\n#..#.\n#..#.\n...#.\n.....");
		String solution = robotPath.solveIt();
		assertThat(solution).isEqualTo("6");
	}

	@Test
	public void shouldHandleBigBoard() {
		StringBuilder board=new StringBuilder("1000\n");
		for (int y=0;y<1000;y++) {
			for (int x=0;x<1000;x++) {
				if (x == 999 || y == 0) {
					board.append(".");
				} else {
					board.append("#");
				}
			}
			if (y < 999) board.append("\n");
		}
		assertThat(new RobotPath(board.toString()).solveIt()).isEqualTo("1");
	}

	@Test
	public void sholdIndicateIllegalBoard() {
		RobotPath robotPath = new RobotPath("4\n....\n###.\n####\n###.");
		String solution = robotPath.solveIt();
		assertThat(solution).isEqualTo("INCONCEIVIBLE");
	}

	@Test
	public void sholdIndicateIfBoardCanBeSolvedGoingUpwards() {
		RobotPath robotPath = new RobotPath("7\n.......\n####...\n.#.....\n.#...#.\n.#.....\n.#..###\n.#.....");
		String solution = robotPath.solveIt();
		assertThat(solution).isEqualTo("THIS BOARD IS A LIE");
	}
}
