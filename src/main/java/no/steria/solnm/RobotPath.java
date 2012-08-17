package no.steria.solnm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RobotPath {
	
	private List<String> parts;
	private int size;
	
	private static class Pos {
		public final int x;
		public final int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
			
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Pos)) return false;
			Pos other = (Pos) obj;
			return (x == other.x && y == other.y);
		}
		
		@Override
		public int hashCode() {
			return new Integer(x).hashCode() + new Integer(y).hashCode();
		}
	}
	
	private Set<Pos> beenOn = new HashSet<>();
	

	public RobotPath(String board) {
		parts = new ArrayList<>(Arrays.asList(board.split("\n")));
		size = Integer.parseInt(parts.remove(0));
	}


	public String solveIt() {
		int solution = solve(0,0);
		if (solution > 0) return "" + solution;
		if (hasSolution(0,0)) return "THIS BOARD IS A LIE";
		return "INCONCEIVIBLE";
	}


	private boolean hasSolution(int x, int y) {
		if (x == size-1 && y == size-1) return true;
		if (x == size || y == size || x < 0 || y < 0) return false;
		if (parts.get(y).charAt(x) == '#') return false;
		if (!beenOn.add(new Pos(x,y))) return false;
		for (int dy=-1;dy<2;dy++) {
			for (int dx=-1;dx<2;dx++) {
				if (hasSolution(x+dx, y+dy)) return true;
			}
		}
		return false;
	}


	private int solve(int x, int y) {
		if (x == size-1 && y == size-1) return 1;
		if (x == size || y == size) return 0;
		if (parts.get(y).charAt(x) == '#') return 0;
		return solve(x+1,y) + solve(x,y+1);
	}

}
