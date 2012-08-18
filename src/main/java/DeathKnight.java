

public class DeathKnight {

	public int solveIt(String codes) {
		String[] battles = codes.split("\n");
		int res = 0;
		for (int i=1;i<battles.length;i++) {
			String battle = battles[i];
			if (!battle.contains("CD")) res++;
		}
		return res;
	}

}
