package checker;

import java.util.ArrayList;
import java.util.List;

import player.BingoDirection;
import player.MadedBingoInformation;

public class BingoChecker {
	
	public static List<MadedBingoInformation> bingoChecker(int[][] bingoBoardForCheck) {
		List<MadedBingoInformation> madedBingoList = new ArrayList<MadedBingoInformation>();
		madedBingoList.addAll(checkDiagonal(bingoBoardForCheck));
		madedBingoList.addAll(checkVerticalAndHorizontal(bingoBoardForCheck));
		return madedBingoList;
		
	}
	
	public static List<MadedBingoInformation> checkDiagonal(int[][] bingoBoardForCheck) {
		List<MadedBingoInformation> madedBingoInfomationList = new ArrayList<MadedBingoInformation>();
	
		int leftDiagonal = 0;
		int rightDiagonal = 0;

		for (int i = 0; i < bingoBoardForCheck.length; i++) {
			if (bingoBoardForCheck[i][i] == 1) {
				leftDiagonal++;
			}
			if (bingoBoardForCheck[bingoBoardForCheck.length -1 -i][1] == 1) {
				rightDiagonal++;
			}
		}

		if (leftDiagonal == bingoBoardForCheck.length) {
			madedBingoInfomationList
			.add(new MadedBingoInformation
					.Builder(BingoDirection.Diagonal, 1)
					.build());		
		}
		if (rightDiagonal == bingoBoardForCheck.length) {
			madedBingoInfomationList
			.add(new MadedBingoInformation
					.Builder(BingoDirection.Diagonal, 2)
					.build());			
		}

		return madedBingoInfomationList;
	}
	
	public static List<MadedBingoInformation> checkVerticalAndHorizontal(int[][] bingoBoardForCheck) {
		
		List<MadedBingoInformation> madedBingoInfomationList = new ArrayList<MadedBingoInformation>();

		for (int i = 0; i < bingoBoardForCheck[0].length; i++) {
			
			int horizontalChecked = 0;
			int verticalChecked = 0;
			
			for (int j = 0; j < bingoBoardForCheck[0].length; j++) {
				if (bingoBoardForCheck[i][j] == 1) {
					horizontalChecked++;
				}
				if (bingoBoardForCheck[j][i] == 1) {
					verticalChecked++;
				}
			}

			if (horizontalChecked == bingoBoardForCheck.length) {
				madedBingoInfomationList
				.add(new MadedBingoInformation
						.Builder(BingoDirection.Horizontal, i+1)
						.build());
			}
			
			if (verticalChecked == bingoBoardForCheck.length) {
				madedBingoInfomationList
				.add(new MadedBingoInformation
						.Builder(BingoDirection.Vertical, i+1)
						.build());			
			}
		}

		return madedBingoInfomationList;
	}

}
