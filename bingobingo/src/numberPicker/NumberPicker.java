package numberPicker;

import java.util.ArrayList;

public class NumberPicker {
	
	public static int randomNumberPicker(int range) {
		int pick = 0;
		pick = (int) (Math.random() * range);

		if (pick == 0) {
			pick = randomNumberPicker(range);
		}
		return pick;
	}
	
	public static int pickNumberChecker(int numberRange, ArrayList<Integer> alredyNumberList) {
		int pick = 0;

		pick = randomNumberPicker(numberRange);

		for (int alreadyNumbering : alredyNumberList) {
			if (pick == alreadyNumbering) {
				pick = pickNumberChecker(numberRange, alredyNumberList);
			}
		}

		alredyNumberList.add(pick);
		return pick;
	}

}
