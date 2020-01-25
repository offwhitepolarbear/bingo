package checker;

import java.util.ArrayList;

import player.BingoDirection;
import player.MadedBingoInfomation;

public class BingoChecker {
	
	public static ArrayList<MadedBingoInfomation> bingoChecker(int[][] bingoBoardForCheck) {
		ArrayList<MadedBingoInfomation> madedBingoList = new ArrayList<MadedBingoInfomation>();
		madedBingoList.addAll(checkDiagonal(bingoBoardForCheck));
		madedBingoList.addAll(checkHorizontal(bingoBoardForCheck));
		madedBingoList.addAll(checkVertical(bingoBoardForCheck));
		
		return madedBingoList;
		
	}
	
	public static ArrayList<MadedBingoInfomation> checkDiagonal(int[][] bingoBoardForCheck) {
		ArrayList<MadedBingoInfomation> madedBingoInfomationList = new ArrayList<MadedBingoInfomation>();
	
		int leftDiagonal = 0;
		int rightDiagonal = 0;

		for (int i = 0; i < bingoBoardForCheck.length; i++) {
			if (bingoBoardForCheck[i][i] == 1) {
				leftDiagonal++;
			}
			if (bingoBoardForCheck[bingoBoardForCheck.length - 1 - i][1] == 1) {
				rightDiagonal++;
			}
		}

		if (leftDiagonal == bingoBoardForCheck.length) {
			madedBingoInfomationList.add(new MadedBingoInfomation(BingoDirection.Diagonal,1));
		}
		if (rightDiagonal == bingoBoardForCheck.length) {
			madedBingoInfomationList.add(new MadedBingoInfomation(BingoDirection.Diagonal,2));
		}

		return madedBingoInfomationList;
	}
	
	public static ArrayList<MadedBingoInfomation> checkHorizontal(int[][] bingoBoardForCheck) {
		
		ArrayList<MadedBingoInfomation> madedBingoInfomationList = new ArrayList<MadedBingoInfomation>();

		for (int i = 0; i < bingoBoardForCheck[0].length; i++) {
			int isChecked = 0;

			for (int j = 0; j < bingoBoardForCheck[0].length; j++) {
				if (bingoBoardForCheck[i][j] == 1) {
					isChecked++;
				}
			}

			if (isChecked == bingoBoardForCheck.length) {
				madedBingoInfomationList.add(new MadedBingoInfomation(BingoDirection.Horizontal,i+1));
			}
		}

		return madedBingoInfomationList;
	}

	public static ArrayList<MadedBingoInfomation> checkVertical(int[][] bingoBoardForCheck) {
		
		ArrayList<MadedBingoInfomation> madedBingoInfomationList = new ArrayList<MadedBingoInfomation>();

		for (int i = 0; i < bingoBoardForCheck[0].length; i++) {
			int isChecked = 0;

			for (int j = 0; j < bingoBoardForCheck[0].length; j++) {
				if (bingoBoardForCheck[j][i] == 1) {
					isChecked++;
				}
			}

			if (isChecked == bingoBoardForCheck.length) {
				madedBingoInfomationList.add(new MadedBingoInfomation(BingoDirection.Vertical,i+1));
			}
		}

		return madedBingoInfomationList;
	}


}
