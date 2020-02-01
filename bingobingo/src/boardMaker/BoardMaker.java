package boardMaker;

import java.util.List;

import numberPicker.NumberPicker;

public class BoardMaker {

	public static void main(String[] args) {
	}

	public static int[][] bingoBoardMaker(List<Integer> numbersForBoard, int boardSize) {

		int[][] bingoBoard = new int[boardSize][boardSize];

		int indexMarker = 0;
		for (int i = 0; i < bingoBoard[0].length; i++) {
			for (int j = 0; j < bingoBoard[0].length; j++) {
				bingoBoard[i][j] = numbersForBoard.get(indexMarker);
				System.out.print(bingoBoard[i][j] + ", ");
				indexMarker++;
			}
			System.out.println();
		}
		System.out.println();

		return bingoBoard;
	}

	public static List<Integer> chooseNumbersForMakingBingoBoard(int numberRange, int boardSize) {
		return NumberPicker.numberSequenceMaker(numberRange, boardSize * boardSize);
	}

}
