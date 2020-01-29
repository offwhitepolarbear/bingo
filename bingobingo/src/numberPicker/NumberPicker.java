package numberPicker;

import java.util.ArrayList;
import java.util.List;

public class NumberPicker {

	public static int randomNumberPicker(int range) {

		int pick = (int) (Math.random() * range)+1;
		
		return pick;
	}

	public static List<Integer> numberSequenceMaker(int numberRange, int needNumberSize) {
		List<Integer> numberingList = new ArrayList<Integer>();
		while (numberingList.size() < needNumberSize) {
			int pick = randomNumberPicker(numberRange);
			if(!isAlreadyPickedNumber(pick, numberingList)) {
				numberingList.add(pick);
			}
		}
		return numberingList;
	}

	private static boolean isAlreadyPickedNumber(int numberForCheck, List<Integer> alreadyNumberingList) {
		boolean result = false;

		for (int alreadyNumbering : alreadyNumberingList) {
			if (numberForCheck == alreadyNumbering) {
				result = true;
				break;
			}
		}

		return result;
	}

}
