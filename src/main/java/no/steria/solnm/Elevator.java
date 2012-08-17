package no.steria.solnm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Elevator {
	private static class Step {
		
		public final int floor;
		public boolean tried = false;
		public final int stepno;

		public Step(int floor,int stepno) {
			this.floor = floor;
			this.stepno = stepno;	
		}
		
		@Override
		public String toString() {
			return "Step<" + floor + ">:" + tried;
		}
	}
	

	public String solve(int floors, int start, int goal, int up, int down) {
		
		
		int numberOfSteps = Integer.MAX_VALUE;

		Stack<Step> stack = new Stack<>();
		stack.push(new Step(start-down,1));
		stack.push(new Step(start+up,1));
		Map<Integer,Integer> tried = new HashMap<>();
		
		while (!stack.isEmpty()) {
			if (stack.size() == numberOfSteps) {
				stack.pop();
				continue;
			}
			Step step = stack.peek();
			if (step.floor < 1 || (step.floor > floors)) {
				stack.pop();
				continue;
			}
			if (step.tried) {
				stack.pop();
				continue;
			}
			if (tried.containsKey(step.floor) && tried.get(step.floor) <= step.stepno) {
				stack.pop();
				continue;
			}
			tried.put(step.floor, step.stepno);
			if (step.floor == goal) {
				numberOfSteps = step.stepno;
				stack.pop();
				continue;
			}
			stack.push(new Step(step.floor - down,step.stepno+1));
			stack.push(new Step(step.floor + up,step.stepno+1));
			step.tried = true;									
			
		}
		if (numberOfSteps < Integer.MAX_VALUE) {
			return "" + numberOfSteps;
		}
		return "use the stairs";
	}

}
