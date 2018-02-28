package teel;

public class JudgeRouteCircle {
	 public boolean judgeCircle(String moves) {
		 char []Moves = moves.toCharArray();
		 int rcount = 0, lcount = 0, ucount = 0, dcount = 0;
		 for (int i = 0; i < Moves.length; i++) {
			 if (Moves[i] == 'R') {
				 rcount++;
			 }
			 if (Moves[i] == 'L') {
				 lcount++;
			 }
			 if (Moves[i] == 'U') {
				 ucount++;
			 }
			 if (Moves[i] == 'D') {
				 dcount++;
			 }
		 }
		 if (rcount == lcount && ucount == dcount) {
			 return true;
		 }
		 return false;
	 }
}
