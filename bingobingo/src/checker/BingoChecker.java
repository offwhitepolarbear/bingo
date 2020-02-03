package checker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import player.BingoDirection;
import player.MadedBingoInformation;

public class BingoChecker {
	
	public static List<MadedBingoInformation> bingoChecker(Map<String, int[]> bingoLineCounter, int boardSize) {
		List<MadedBingoInformation> madedBingoList = new ArrayList<MadedBingoInformation>();
		madedBingoList.addAll(checkDiagonal(bingoLineCounter, boardSize));
		madedBingoList.addAll(checkVerticalAndHorizontal(bingoLineCounter, boardSize));
		return madedBingoList;
	}
	
	public static List<MadedBingoInformation> checkDiagonal(Map<String, int[]> bingoLineCounter, int boardSize) {
		List<MadedBingoInformation> madedBingoInfomationList = new ArrayList<MadedBingoInformation>();
		
		int[]diagonalCounter = bingoLineCounter.get("diagonalCheckCounter");

		if (diagonalCounter[0] == boardSize) {
			madedBingoInfomationList
			.add(new MadedBingoInformation
					.Builder(BingoDirection.Diagonal, 1)
					.build());		
		}
		if (diagonalCounter[1] == boardSize) {
			madedBingoInfomationList
			.add(new MadedBingoInformation
					.Builder(BingoDirection.Diagonal, 2)
					.build());			
		}

		return madedBingoInfomationList;
	}
	
	public static List<MadedBingoInformation> checkVerticalAndHorizontal(Map<String, int[]> bingoLineCounter, int boardSize) {
		List<MadedBingoInformation> madedBingoInfomationList = new ArrayList<MadedBingoInformation>();

		int[]horizontalCounter = bingoLineCounter.get("horizontalCheckCounter");
		int[]verticalCounter = bingoLineCounter.get("verticalCheckCounter");

		for (int i=0; i< boardSize;i++) {
			if (horizontalCounter[i]==boardSize) {
				madedBingoInfomationList.add(
						new MadedBingoInformation
						.Builder(BingoDirection.Horizontal, i+1)
						.build());
			}
			if (verticalCounter[i]==boardSize) {
				madedBingoInfomationList.add(
						new MadedBingoInformation
						.Builder(BingoDirection.Vertical, i+1)
						.build());		
			}
		}
			
		return madedBingoInfomationList;
	}

}
