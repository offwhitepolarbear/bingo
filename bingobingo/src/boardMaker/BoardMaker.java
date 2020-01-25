package boardMaker;

import java.util.ArrayList;

import numberPicker.NumberPicker;

public class BoardMaker {
	
	public static int[][] bingoBoardMaker(int maximumNumberRange, int boardSize){
		int[][] bingoBoard = new int[boardSize][boardSize];
		ArrayList<Integer> numbersForBoard = NumberPicker.numberSequenceMaker(maximumNumberRange, boardSize*boardSize);
		for(int i=0;i<bingoBoard[0].length;i++) {
			int indexMarker = 0;
			for(int j=0;j<bingoBoard[0].length;j++) {
				bingoBoard[i][j]=numbersForBoard.get(indexMarker);
				System.out.println("보드만드는중 입력된 숫자는 "+numbersForBoard.get(indexMarker));
				indexMarker++;
				
			}
		}
		return bingoBoard;
	}
}
